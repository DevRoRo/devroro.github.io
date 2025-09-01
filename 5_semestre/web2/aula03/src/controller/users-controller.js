import { select } from "../config/db.js"

function mostraListaUsuarios(req, res) {
    const dados = select();
    res.render('users-lista', { dados })
}

export {mostraListaUsuarios}