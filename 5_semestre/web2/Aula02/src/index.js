import express from 'express';

const app = express();
const port = 3000;

app.set('view engine', 'ejs');
app.set('views', 'src/views');

app.use(express.static('public'))

app.get('/', (req, res) => {
  res.render('Hello World!');
});

app.get('/products', (req, res) => {
    res.render('products', { products: products });
});

app.get('/products:id', (req, res) => {
    const id = req.params.id;
    const productComId = products.filter(p => p.id == id)[0];
    res.render('productsDetails', {productComId});
})

const products = [
    {
        id: 1,
        name: 'Motherboard',
        price: 250
    },
    {
        id: 2,
        name: 'CPU',
        price: 300
    },
    {
        id: 3,
        name: 'RAM',
        price: 150
    },
    {
        id: 4,
        name: 'GPU 1',
        price: 400
    },
    {
        id: 5,
        name: 'GPU 2',
        price: 450
    }
];

/*
PAGINAS ESTATICAS
*/

/*
TEMPLATES
*/

/*
Rotas com Parâmetros e Query Params

Crie um endpoint GET /produtos/:id que retorna detalhes de um produto.

Crie um endpoint GET /busca que recebe um query param nome e retorna apenas os produtos que contêm esse nome.

Exemplo:
GET /busca?nome=camisa
*/


/*
Middleware

Crie um middleware que:

Registra no console cada requisição feita (rota, método e hora).

Bloqueia acesso a certas rotas (POST /products) se não tiver um header Authorization válido.
*/

app.listen(port, () => {
  console.log(`Server is running at http://localhost:${port}`);
});
