const db = [
    {
        id: 1,
        name: "Vinicius Machado",
        username: "@vfmachado",
        role: 'ADMIN',
        status: "ACTIVE",
        email: "vinicius.machado@riogrande.ifrs.edu.br",
        createdAt: "2025-08-26",
        password: "1234"
    }
]

function sort(filter) {
    const filtrado = db.find(filter)
    console.log(filtrado)
}

export function select(filter) {
    return [...db];
}

export function add(dados) {
    db.push(dados)
}

export function show() {
    console.log(db)
}