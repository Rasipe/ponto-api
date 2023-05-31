import React, { useState, useEffect } from 'react';
import { getUltimosPontos, registrarPonto } from '../utils/api';
import { Link, useParams } from 'react-router-dom';

const Ponto = () => {
  let { id } = useParams();
  const [pontos, setPontos] = useState([]);
  const [horarioEntrada, setHorarioEntrada] = useState('');
  const [horarioSaida, setHorarioSaida] = useState('');
  const [dataHora, setDataHora] = useState('');
  const [pausaAlmoco, setPausaAlmoço] = useState('');

  useEffect(() => {
    fetchPontos();
  }, []);

  const fetchPontos = async () => {
    const data = await getUltimosPontos(id);
    setPontos(data || []);
  };

  const handleHorarioEntradaChange = (event) => {
    setHorarioEntrada(event.target.value);
  };

  const handleHorarioSaidaChange = (event) => {
    setHorarioSaida(event.target.value);
  };

  const handleDataHora = (event) => {
    setDataHora(event.target.value);
  };
  
  const handlePausaAlmoco = (event) => {
    setPausaAlmoço(event.target.value);
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      await registrarPonto({
        funcionarioId: id,
        dataHora: new Date(dataHora).toISOString(),
        entrada: horarioEntrada,
        saida: horarioSaida,
        pausaAlmoco: pausaAlmoco
      })
      setHorarioEntrada('');
      setHorarioSaida('');
      setDataHora('');
      setPausaAlmoço('')
      fetchPontos();
    } catch (error) {
      
    }
  };

  return (
    <div>
      <h2>Pontos</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="horarioEntrada" className="form-label">Horário de Entrada</label>
          <input
            type="text"
            className="form-control"
            id="horarioEntrada"
            value={horarioEntrada}
            onChange={handleHorarioEntradaChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="horarioSaida" className="form-label">Horário de Saída</label>
          <input
            type="text"
            className="form-control"
            id="horarioSaida"
            value={horarioSaida}
            onChange={handleHorarioSaidaChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="dataHora" className="form-label">Data</label>
          <input
            type="text"
            className="form-control"
            id="dataHora"
            value={dataHora}
            onChange={handleDataHora}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="pausaAlmoco" className="form-label">Tempo de pausa para almoço</label>
          <input
            type="text"
            className="form-control"
            id="pausaAlmoco"
            value={pausaAlmoco}
            onChange={handlePausaAlmoco}
          />
        </div>
        <button type="submit" className="btn btn-primary my-3">Registrar Ponto</button>
        <Link className='text-secondary' style={{textDecoration: "none"}} to={`/extrato/${id}`}>
          <button type="submit" className="btn btn-outline-primary ms-3 my-3">ver extrato</button>
        </Link>
      </form>

      <h3>Últimos 10 Pontos:</h3>
      <ul className="list-group">
        {pontos.map((ponto) => (
          <li className="list-group-item" key={ponto.id}>
              {new Date(ponto.dataHora).toLocaleDateString()} | Entrada: {ponto.entrada} - Saída: {ponto.saida}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Ponto;
