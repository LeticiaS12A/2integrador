const relatorioform = document.getElementById('relatorioForm');
const relatorioList = document.getElementById('relatorioList');

relatorioform.addEventListener('submit', async (event) => {
    event.preventDefault();

    const nomeRelatorio = document.getElementById('nomeRelatorio').value;
	const nomeSetor = document.getElementById('nomeSetor').value;
	const nomeCriador = document.getElementById('nomeCriador').value;
	const texto = document.getElementById('texto').value;
    const urlImagem = document.getElementById('urlImagem').value;

    const relatorio = { nomeRelatorio, nomeSetor, nomeCriador, texto, urlImagem };

    try {
        const response = await fetch(`http://localhost:8080/a/pi`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(relatorio)
        });

        if (response.ok) {
            await listarRelatorio(); // Atualiza a lista após adicionar
            relatorioform.reset(); // Limpa o formulário
        } else {
            alert('Erro ao adicionar relatorio');
        }
    } catch (error) {
        console.error('Erro:', error);
    }
});

// Função para listar produtos
async function listarRelatorio() {
    try {
        const response = await fetch('http://localhost:8080/a');
        const relatorios = await response.json();

        relatorioList.innerHTML = ''; // Limpa a lista existente
        relatorios.forEach(relatorio => {
            const li = document.createElement('li');
            li.innerHTML = `
                <strong>${relatorio.nomeRelatorio}</strong><br>
				<strong>${relatorio.nomeSetor}</strong><br>
				<strong>${relatorio.nomeCriador}</strong><br>
				<strong>${relatorio.texto}</strong><br>
                <img src="${relatorio.urlImagem}" alt="${relatorio.nomeRelatorio}"
				alt="${relatorio.nomeSetor}" alt="${relatorio.nomeCriador}" alt="${relatorio.texto}"><br>
                <a href="#" onclick="deletarRelatorio(${relatorio.id})">Deletar</a>
            `;
            relatorioList.appendChild(li);
        });
    } catch (error) {
        console.error('Erro:', error);
    }
}

// Função para deletar um produto
async function deletarRelatorio(id) {
    if (confirm('Tem certeza que deseja deletar este relatorio?')) {
        try {
            const response = await fetch(`http://localhost:8080/a/${id}`, {
                method: 'DELETE'
            });

            if (response.ok) {
                await listarRelatorio(); // Atualiza a lista após deletar
            } else {
                alert('Erro ao deletar relatorio');
            }
        } catch (error) {
            console.error('Erro:', error);
        }
    }
}


// Carrega os produtos ao iniciar
listarRelatorio();
