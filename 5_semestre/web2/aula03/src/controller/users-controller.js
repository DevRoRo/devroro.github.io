import { select } from "../config/db.js"
import { add } from "../config/db.js"
import { show } from "../config/db.js"

function mostraListaUsuarios(req, res) {
    const dados = select();
    res.render('users-lista', { dados })
}

export {mostraListaUsuarios}

function mostraForm(req, res) {
    res.render('users-form')
} 

export {mostraForm}

function receberInfo(req, res) {
    const dados = req.body
    
    const nome = dados.name
    dados.username = nome.split(' ').map(part => part.slice(0, 4).toLowerCase()).join('')
    
    const agora = new Date().toISOString()
    const agoraFormatado = agora.split("T")
    dados.createdAt = agoraFormatado[0]

    add(dados)
    res.redirect("lista")
}

export {receberInfo}

function editarUsuario(req, res) {
    const dados = select(req.body.name)
    console.log(dados)
    res.render('users-form-edit', { dados })
}

export {editarUsuario}