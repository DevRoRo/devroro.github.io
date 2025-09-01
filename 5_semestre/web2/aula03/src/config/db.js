const db = [
    {
        id: 1,
        name: "Vinicius Machado",
        username: "@vfmachado",
        role: 'ADMIN',
        status: "ACTIVE",
        email: "vinicius.machado@riogrande.ifrs.edu.br",
        createdAt: "2025-08-26"
    }
]

export function select(filter) {
    return [...db];
}