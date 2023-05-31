import React, { useState } from 'react';
import { useParams } from 'react-router-dom';
import { getExtratoMensal } from '../utils/api';

const Extrato = () => {
  let { id } = useParams();
  const [mes, setMes] = useState('');
  const [ano, setAno] = useState('');
  const [extrato, setExtrato] = useState({});

  const handleMesChange = (event) => {
    setMes(event.target.value);
  };

  const handleAnoChange = (event) => {
    setAno(event.target.value);
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    const data = await getExtratoMensal(id, mes, ano);
    setExtrato(data);
  };

  return (
    <div>
      <h2>Extrato Mensal</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="mes" className="form-label">Mês</label>
          <input
            type="text"
            className="form-control"
            id="mes"
            value={mes}
            onChange={handleMesChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="ano" className="form-label">Ano</label>
          <input
            type="text"
            className="form-control"
            id="ano"
            value={ano}
            onChange={handleAnoChange}
          />
        </div>
        <button type="submit" className="btn btn-primary">Buscar Extrato</button>
      </form>

      <h3>Extrato:</h3>
      { (extrato && Object.keys(extrato).length > 0) && (<>
        <div class="alert alert-secondary" role="alert">
          <strong> Funcionário: </strong>
          <span className='text-primary'> {extrato.funcionarioNome} </span>
          <br />
          <strong> Horas Totais: </strong>
          <span className='text-primary'> {extrato.horasTrabalhadas} </span>
          <br />
          <strong> Valor Total:  </strong>
          <span className='text-primary'> R$ {extrato.valorTotal.toFixed(2)} </span>
        </div>
        <ul className='list-group'>
          {extrato.diasTrabalhadas?.map(item => 
            <li className="list-group-item">
              {new Date(item).toLocaleDateString()}
            </li>
          )}
        </ul>
      </>)}
    </div>
  );
};

export default Extrato;
