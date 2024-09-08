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
