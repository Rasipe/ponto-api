import React from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import Funcionarios from './pages/Funcionarios';
import NovoFuncionario from './pages/NovoFuncionario';
import Ponto from './pages/Ponto';
import Extrato from './pages/Extrato';

const App = () => {
  return (
    <Router>
      <div className="container">
        <Switch>
          <Route exact path="/" component={Funcionarios} />
          <Route exact path="/funcionarios" component={Funcionarios} />
          <Route exact path="/novo-funcionario" component={NovoFuncionario} />
          <Route exact path="/novo-funcionario/:id" component={NovoFuncionario} />
          <Route exact path="/ponto/:id" component={Ponto} />
          <Route exact path="/extrato/:id" component={Extrato} />
        </Switch>
      </div>
    </Router>
  );
};

export default App;