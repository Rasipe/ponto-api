const BASE_URL = 'http://localhost:8080';

export async function adicionarFuncionario(funcionario) {
  debugger

  try {
    const response = await fetch(`${BASE_URL}/funcionario`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(funcionario),
    });

    return response;
  } catch (error) {
    console.log(error);
  }
}

export async function getFuncionarios() {
  
  try {
    const response = await fetch(`${BASE_URL}/funcionario`);
    const data = await response.json();
    return data;
  } catch (error) {
    console.log(error);
  }
}

export async function registrarPonto(body) {
  try {
    const response = await fetch(`${BASE_URL}/ponto`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(body),
    });

    if (response.ok) {
    } else {
      console.log('Erro ao adicionar ponto');
    }
  } catch (error) {
    console.log(error);
  }
}

export async function getUltimosPontos(funcionarioId) {
  
  try {
    const response = await fetch(`${BASE_URL}/ponto/funcionario/${funcionarioId}/ultimos?quantidade=10`);
    const data = await response.json();
    return data;
  } catch (error) {
    console.log(error);
  }
}

export async function getExtratoMensal(funcionarioId, mes, ano) {
  try {
    const response = await fetch(`${BASE_URL}/extrato-mensal/${funcionarioId}?mes=${mes}&ano=${ano}`);
    const data = await response.json();
    return data;
  } catch (error) {
    console.log(error);
  }
}

export async function calcularSalario(idFuncionario, mes, ano) {
  const response = await fetch(`${BASE_URL}/salarios?funcionario=${idFuncionario}&mes=${mes}&ano=${ano}`);

  if (!response.ok) {
    throw new Error('Erro ao calcular salário');
  }

  const salario = await response.json();
  return salario;
}

export async function deletarFuncionario(id) {
  try {
    const response = await fetch(`${BASE_URL}/funcionario/${id}`, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json',
      }
    });

    if (response.ok) {
    } else {
      console.log('Erro ao excluir funcionario');
    }
  } catch (error) {
    console.log(error);
  }
}