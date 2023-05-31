import React, { useEffect, useState } from 'react';
import { Link, useHistory } from 'react-router-dom';
import { deletarFuncionario, getFuncionarios } from '../utils/api';

const Funcionarios = () => {
  const [funcionarios, setFuncionarios] = useState([]);
  const history = useHistory();
  
  const carregarFuncionarios = async () => {
    const data = await getFuncionarios();
    setFuncionarios(data || []);
  };

  useEffect(() => {
    carregarFuncionarios();
  }, []);

  async function excluirFuncionario(id) {
    await deletarFuncionario(id);
    await carregarFuncionarios()
  }

  function editarFuncionario(id) {
    history.push('/novo-funcionario/'+id)
  }

  return (
    <div>
      <h2>Lista de Funcionários</h2>
        <Link to="/novo-funcionario" className="btn btn-primary">Adicionar Funcionário</Link>
        {funcionarios.length > 0
        ? funcionarios.map((funcionario) => (
          <ul className="list-group">
            <li className="list-group-item d-flex justify-content-between" key={funcionario.id}>
              <Link className='text-secondary' style={{textDecoration: "none"}} to={`/ponto/${funcionario.id}`}>
                <span className='fs-4 text-primary'>{funcionario.nome}</span> - {funcionario.cpf} - R$ {funcionario.valorHora.toFixed(2)}
              </Link>
              <div className='d-flex'>
                <button type="button" class="btn btn-primary" onClick={() => editarFuncionario(funcionario.id)}>Editar</button>
                <button type="button" class="btn btn-danger ms-3" onClick={() => excluirFuncionario(funcionario.id)}>Excluir</button>
              </div>
            </li>
          </ul>
        ))
        : <div className="alert alert-primary mt-3" role="alert"> Nenhum funcionário encontrado </div>
      }
    </div>
  );
};

export default Funcionarios;