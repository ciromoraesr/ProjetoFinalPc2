# ProjetoFinalPc2


## Instruções para Conectar ao Banco de Dados

### 1. Configuração do Banco de Dados

Antes de rodar o projeto, você precisará configurar o banco de dados PostgreSQL. Siga os passos abaixo:

1. Crie um banco de dados no **PgAdmin4**.
2. Execute as seguintes queries para criar as tabelas necessárias (também estão contidas em tabelas.sql):

```sql
CREATE TABLE IF NOT EXISTS Cliente (
    codCliente SERIAL PRIMARY KEY,
    nomeCliente VARCHAR(50) NOT NULL,
    rgCliente VARCHAR NOT NULL,
    enderecoCliente VARCHAR NOT NULL,
    bairroCliente VARCHAR NOT NULL,
    cidadeCliente VARCHAR NOT NULL,
    estadoCliente VARCHAR NOT NULL,
    CEPCliente VARCHAR NOT NULL,
    nascimentoCliente DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS Chale (
    codChale SERIAL PRIMARY KEY,
    localizacao VARCHAR NOT NULL,
    capacidade INTEGER NOT NULL,
    valorAltaEstacao FLOAT NOT NULL,
    valorBaixaEstacao FLOAT NOT NULL
);

CREATE TABLE IF NOT EXISTS Hospedagem (
    codHospedagem SERIAL PRIMARY KEY,
    codChale INTEGER,
    codCliente INTEGER,
    CONSTRAINT fk_chale_hospedagem FOREIGN KEY (codChale) REFERENCES Chale(codChale),
    CONSTRAINT fk_cliente_hospedagem FOREIGN KEY (codCliente) REFERENCES Cliente(codCliente),
    dataInicio DATE NOT NULL,
    dataFim DATE NOT NULL,
    qtdPessoas INTEGER NOT NULL,
    desconto FLOAT NOT NULL,
    valorFinal FLOAT NOT NULL
);
```
### 2. Configuração ConnectionFactory

Após criar as tabelas no banco de dados, abra o arquivo ConnectionFactory.java e ajuste as configurações de conexão (URL, usuário, senha) conforme os dados do seu banco de dados PostgreSQL.


### 3. Execução do Projeto
1. Certifique-se de que todas as dependências necessárias estejam configuradas no seu ambiente Java, como o JDBC.
2. Se estiver utilizando WindowBuilder para interface gráfica, lembre-se de configurá-lo corretamente no seu editor.
3. Após isso, você já deve conseguir rodar o projeto diretamente no seu editor de código JAVA.
