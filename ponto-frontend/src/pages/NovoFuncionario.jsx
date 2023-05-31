import React, { useState } from 'react';
import { useHistory, useParams } from 'react-router-dom';
import { adicionarFuncionario } from '../utils/api';

const NovoFuncionario = () => {
  let { id } = useParams();
  const [nome, setNome] = useState('');
  const [cpf, setCPF] = useState('');
  const [valorHora, setValorHora] = useState();

  const history = useHistory();

  const handleSubmit = async (event) => {
    event.preventDefault();
    const body = {nome, cpf, valorHora};
    if (id) {
      body.id = id;
    }

    const response = await adicionarFuncionario(body)

    if (response.ok) {
      history.push('/funcionarios');
    } else {
      console.log('Erro ao adicionar funcionário');
    }
  };

  return (
    <div>
      <h2>Adicionar Novo Funcionário</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="nome" className="form-label">Nome</label>
          <input
            type="text"
            className="form-control"
            id="nome"
            value={nome}
            onChange={(event) => { setNome(event.target.value); }}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="cpf" className="form-label">CPF</label>
          <input
            type="text"
            className="form-control"
            id="cpf"
            value={cpf}
            onChange={(event) => { setCPF(event.target.value); }}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="valor-hora" className="form-label">Valor hora</label>
          <input
            type="number"
            className="form-control"
            id="valor-hora"
            value={valorHora}
            onChange={(event) => { setValorHora(parseInt(event.target.value)); }}
          />
        </div>
        <button type="submit" className="btn btn-primary">Adicionar</button>
      </form>
    </div>
  );
};

export default NovoFuncionario;
