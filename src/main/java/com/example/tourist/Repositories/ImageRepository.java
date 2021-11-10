package com.example.tourist.Repositories;

import com.example.tourist.dao.ImageDao;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.UUID;
@Repository("Picture")
public class ImageRepository implements ImageDao {
    private static final String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/tourist-40c97.appspot.com/o/%s?alt=media";

    NamedParameterJdbcTemplate template;
    JdbcTemplate jdbcTemplate;

    public ImageRepository(NamedParameterJdbcTemplate template, JdbcTemplate jdbcTemplate) {
        this.template = template;
        this.jdbcTemplate = jdbcTemplate;
    }







    public int save(String path,int LocationId){
        final String sql = "insert into Pictures(url,location_id) values(?,?);";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("url", path)
                .addValue("locationId", LocationId);
        try {


            jdbcTemplate.update(sql,path,LocationId);
            return 1;

        }catch (Exception e){

            return 0;
        }
    }


    @Override
    public List<String> getPictureByLocationId(int id) {
        String sql="SELECT url from Pictures left join Locations on Pictures.location_id=Locations.id where Pictures.location_id=:id;";
        SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);

        return template.query(sql,param,pictureRowMapper);
    }

    @Override
    public String upload(MultipartFile IncomingFile,int id) {
        try {
            String fileName = IncomingFile.getOriginalFilename();
            // to get original file name

            fileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));  // to generated random string values for file name.

            File file = this.convertToFile(IncomingFile, fileName);                      // to convert multipartFile to File
            String TEMP_URL = this.uploadFile(file, fileName);                                   // to get uploaded file link
            file.delete();// to delete the copy of uploaded file stored in the project folder

            this.save(TEMP_URL,id);
            return TEMP_URL;                     // Your customized response
        } catch (Exception e) {
            e.printStackTrace();
            return "500"+ "Unsuccessfully Uploaded!";
        }

    }



    private String uploadFile(File file, String fileName) throws IOException {
        BlobId blobId = BlobId.of("tourist-40c97.appspot.com", fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
        Credentials credentials = GoogleCredentials.fromStream(new FileInputStream("tourist-40c97-firebase-adminsdk-he8mj-6b85e12c3f.json"));
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        storage.create(blobInfo, Files.readAllBytes(file.toPath()));
        return String.format(DOWNLOAD_URL, URLEncoder.encode(fileName, StandardCharsets.UTF_8));
    }

    private File convertToFile(MultipartFile multipartFile, String fileName) throws IOException {
        File tempFile = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(multipartFile.getBytes());
            fos.close();
        }
        return tempFile;
    }

    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    private final RowMapper<String> pictureRowMapper =((rs, rowNum) -> {
        return rs.getString("url");
    });

}
