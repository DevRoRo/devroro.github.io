import { Router } from "express";
import { mostraForm, mostraListaUsuarios, receberInfo, editarUsuario } from "../controller/users-controller.js";

const usersRouter = Router();

const respostaPadrao = (req, res) => { res.send("FUNCIONA")}

usersRouter.get('/criar', respostaPadrao)
usersRouter.post('/criar', respostaPadrao)
usersRouter.get('/lista', mostraListaUsuarios)
usersRouter.get('/delete', respostaPadrao)
usersRouter.get('/edit', editarUsuario)
usersRouter.get('/forms', mostraForm)
usersRouter.post('/forms', respostaPadrao)
usersRouter.post('/receberInfo', receberInfo)

export { usersRouter }
