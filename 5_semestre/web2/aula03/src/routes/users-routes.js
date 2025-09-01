import { Router } from "express";
import { mostraListaUsuarios } from "../controller/users-controller.js";

const usersRouter = Router();

const respostaPadrao = (req, res) => { res.send("FUNCIONA")}

usersRouter.get('/criar', respostaPadrao)
usersRouter.post('/criar', respostaPadrao)
usersRouter.get('/lista', mostraListaUsuarios)
usersRouter.get('/delete', respostaPadrao)
usersRouter.get('/edit', respostaPadrao)
usersRouter.post('/edit', respostaPadrao)

export { usersRouter }
