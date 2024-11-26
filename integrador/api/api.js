
import axios from "axios"

const buttongetter = document.getElementById("teste")

buttongetter.addEventListener("click",()=>{
    console.log("oie")
})




const api = axios.create({
    BASE_URL : 'http://localhost:8080',
})

const getRelatorio = async()=> {
    const relatorios = await api.get('get')
    console.log(relatorios.data)
}

