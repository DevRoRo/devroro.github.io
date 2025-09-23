import express from "express"

const app = express()
const port = 3000

app.use(express.urlencoded({ extended: false }))

app.set("view engine", "ejs")
app.set('views', "./views")

app.post('/form', (req, res) => {
    console.log("Body do Post request: ")
    console.log(req.body)
    res.render('index')
})

app.post('/', (req, res) => {
    console.log(req.body)
    console.log(res.status)
    const date = req.headers
    res.render('index', { date })
})

app.listen(port, () => {
    console.log(`Example app listening on port ${port}`)
})