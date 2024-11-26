

//criar relatorio


// Função para enviar o formulário e criar um novo relatório
function createRelatorio() {
    // Coletando os dados do formulário
    const nomeRelatorio = document.querySelector(".info-relatorio[placeholder='Nome do Relatório']").value;
    const nomeSetor = document.querySelector(".info-relatorio[placeholder=' Nome do Setor']").value;
    const nomeCriador = document.querySelector(".info-relatorio[placeholder='Nome do Criador do Relatório']").value;
    const urlImagem = document.querySelector(".info-relatorio[placeholder='URL da Imagem']").value;
    const texto = document.querySelector(".digite-aqui").value;

    // Verificando se os campos estão preenchidos
    if (!nomeRelatorio || !nomeSetor || !nomeCriador || !urlImagem || !texto) {
        alert("Todos os campos devem ser preenchidos!");
        return;
    }

    // Criando o objeto com os dados do relatório
    const relatorioData = {
        nomeRelatorio: nomeRelatorio,
        nomeSetor: nomeSetor,
        nomeCriador: nomeCriador,
        urlImagem: urlImagem,
        texto: texto
    };

    // Enviando os dados para o back-end
    fetch('/api/relatorios', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(relatorioData)
    })
    .then(response => response.json())
    .then(data => {
        console.log('Relatório criado com sucesso:', data);
        alert('Relatório criado com sucesso!');
        // Opcional: Limpar os campos após sucesso
        document.querySelector(".info-relatorio[placeholder='Nome do Relatório']").value = '';
        document.querySelector(".info-relatorio[placeholder=' Nome do Setor']").value = '';
        document.querySelector(".info-relatorio[placeholder='Nome do Criador do Relatório']").value = '';
        document.querySelector(".info-relatorio[placeholder='URL da Imagem']").value = '';
        document.querySelector(".digite-aqui").value = '';
    })
    .catch(error => {
        console.error('Erro ao criar relatório:', error);
        alert('Ocorreu um erro ao criar o relatório!');
    });
}


//atualizar relatorio


// Função para editar e atualizar um relatório existente
function updateRelatorio(id) {
    // Coletando os dados do formulário
    const nomeRelatorio = document.querySelector(".info-relatorio[placeholder='Nome do Relatório']").value;
    const nomeSetor = document.querySelector(".info-relatorio[placeholder=' Nome do Setor']").value;
    const nomeCriador = document.querySelector(".info-relatorio[placeholder='Nome do Criador do Relatório']").value;
    const urlImagem = document.querySelector(".info-relatorio[placeholder='URL da Imagem']").value;
    const texto = document.querySelector(".digite-aqui").value;

    // Verificando se os campos estão preenchidos
    if (!nomeRelatorio || !nomeSetor || !nomeCriador || !urlImagem || !texto) {
        alert("Todos os campos devem ser preenchidos!");
        return;
    }


    // Enviando os dados para o back-end
    fetch(`/api/relatorios/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(relatorioData)
    })
    .then(response => response.json())
    .then(data => {
        console.log('Relatório atualizado com sucesso:', data);
        alert('Relatório atualizado com sucesso!');
    })
    .catch(error => {
        console.error('Erro ao atualizar relatório:', error);
        alert('Ocorreu um erro ao atualizar o relatório!');
    });
}

//deletar relatorio

// Função para deletar um relatório
function deleteRelatorio(id) {
    fetch(`/api/relatorios/${id}`, {
        method: 'DELETE',
    })
    .then(response => {
        if (response.ok) {
            console.log('Relatório deletado com sucesso');
            alert('Relatório deletado com sucesso!');
        } else {
            console.error('Falha ao deletar o relatório');
            alert('Erro ao deletar o relatório!');
        }
    })
    .catch(error => {
        console.error('Erro na requisição de deleção:', error);
        alert('Erro ao deletar o relatório!');
    });
}
