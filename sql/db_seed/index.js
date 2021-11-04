require('dotenv').config()
const { Pool, Client } = require('pg')
const faker = require('faker');
let city=faker.address.country();
console.log(city)
console.log(process.env.PGUSER)
const pool = new Pool({
    ssl: {rejectUnauthorized:false},
  })
const seedCountries = async()=>{

  for(let i=0;i<50;i+=1){
     
let name=faker.address.country()
console.log(name)
     await new Promise(next=> {
      pool.query(`INSERT INTO "Countries" VALUES ('${name}'); `, (err, res) => {
        if (err) throw err;
         console.log("done")
         next()
       })
    
    
    })
     console.log(i)
    }
  
pool.end()
}

const seedCities = async()=>{

  for(let i=60;i<110;i+=1){
     
let name=faker.address.city()
console.log(name)
     await new Promise(next=> {
      pool.query(`INSERT INTO "Cities" VALUES ('${name}','${i}'); `, (err, res) => {
        if (err) throw err;
         console.log("done")
         next()
       })
    
    
    })
     console.log(i)
    }
  
pool.end()
}

   seedCities()





 
 