CREATE
DATABASE projects2024;

CREATE SCHEMA bluebank;


CREATE SEQUENCE bluebank.ciudades_ciu_id_seq;

CREATE TABLE bluebank.CIUDADES
(
    CIU_ID      INTEGER      NOT NULL DEFAULT nextval('bluebank.ciudades_ciu_id_seq'),
    CIU_NOMBRE  VARCHAR(100) NOT NULL,
    CIU_CODPOST VARCHAR(10),
    CONSTRAINT ciudades_fk PRIMARY KEY (CIU_ID)
);
COMMENT
ON TABLE bluebank.CIUDADES IS 'CIUDADES DONDE SE REGISTRAN CUENTAS';
COMMENT
ON COLUMN bluebank.CIUDADES.CIU_ID IS 'IDENTIFICADOR DEL DATO';
COMMENT
ON COLUMN bluebank.CIUDADES.CIU_NOMBRE IS 'NOMBRE DE LA CIUDAD';
COMMENT
ON COLUMN bluebank.CIUDADES.CIU_CODPOST IS 'CODIGO POSTAL DE LA CIUDAD';


ALTER SEQUENCE bluebank.ciudades_ciu_id_seq OWNED BY bluebank.CIUDADES.CIU_ID;

CREATE SEQUENCE bluebank.cliente_cli_id_seq;

CREATE TABLE bluebank.CLIENTE
(
    CLI_ID       INTEGER      NOT NULL DEFAULT nextval('bluebank.cliente_cli_id_seq'),
    CLI_NOMBRE   VARCHAR(200) NOT NULL,
    CLI_TIPO     VARCHAR(1)   NOT NULL,
    CLI_TELEFONO NUMERIC(10)  NOT NULL,
    CONSTRAINT cliente_fk PRIMARY KEY (CLI_ID)
);
COMMENT
ON TABLE bluebank.CLIENTE IS 'CLIENTES DE BLUE BANK';
COMMENT
ON COLUMN bluebank.CLIENTE.CLI_ID IS 'IDENTIFICADOR DEL DATO';
COMMENT
ON COLUMN bluebank.CLIENTE.CLI_NOMBRE IS 'NOMBRES CLIENTE';
COMMENT
ON COLUMN bluebank.CLIENTE.CLI_TIPO IS 'TIPO DE CLIENTE P:PERSONA E:EMPRESA';
COMMENT
ON COLUMN bluebank.CLIENTE.CLI_TELEFONO IS 'TELEFONO DEL CLIENTE';


ALTER SEQUENCE bluebank.cliente_cli_id_seq OWNED BY bluebank.CLIENTE.CLI_ID;

CREATE SEQUENCE bluebank.cuenta_cue_id_seq;

CREATE TABLE bluebank.CUENTA
(
    CUE_ID     INTEGER     NOT NULL DEFAULT nextval('bluebank.cuenta_cue_id_seq'),
    CUE_TIPO   VARCHAR(1)  NOT NULL,
    CUE_NUMERO VARCHAR(20) NOT NULL,
    CUE_SALDO  NUMERIC     NOT NULL,
    CLI_ID     INTEGER     NOT NULL,
    CIU_ID     INTEGER     NOT NULL,
    CONSTRAINT cuenta_fk PRIMARY KEY (CUE_ID)
);
COMMENT
ON TABLE bluebank.CUENTA IS 'CUENTAS DE LOS CLIENTES';
COMMENT
ON COLUMN bluebank.CUENTA.CUE_ID IS 'IDENTIFICADOR DEL DATO';
COMMENT
ON COLUMN bluebank.CUENTA.CUE_TIPO IS 'TIPO DE CUENTA A:AHORROS C:CORRIENTE';
COMMENT
ON COLUMN bluebank.CUENTA.CUE_NUMERO IS 'NUMERO DE CUENTA';
COMMENT
ON COLUMN bluebank.CUENTA.CUE_SALDO IS 'SALDO ACTUAL DE LA CUENTA';
COMMENT
ON COLUMN bluebank.CUENTA.CLI_ID IS 'CLIENTE ASOCIADO A LA CUENTA';
COMMENT
ON COLUMN bluebank.CUENTA.CIU_ID IS 'CIUDAD ORIGEN D ELA CUENTA';


ALTER SEQUENCE bluebank.cuenta_cue_id_seq OWNED BY bluebank.CUENTA.CUE_ID;

CREATE SEQUENCE bluebank.movimientos_mov_id_seq;

CREATE TABLE bluebank.MOVIMIENTOS
(
    MOV_ID    INTEGER    NOT NULL DEFAULT nextval('bluebank.movimientos_mov_id_seq'),
    CUE_ID    INTEGER    NOT NULL,
    MOV_FECHA DATE       NOT NULL,
    MOV_TIPO  VARCHAR(1) NOT NULL,
    MOV_VALOR NUMERIC    NOT NULL,
    CIU_ID    INTEGER    NOT NULL,
    CONSTRAINT movimientos_fk PRIMARY KEY (MOV_ID)
);
COMMENT
ON TABLE bluebank.MOVIMIENTOS IS 'RETIROS Y CONSIGNACIONES DE LOS CLIENTES';
COMMENT
ON COLUMN bluebank.MOVIMIENTOS.MOV_ID IS 'IDENTIFICADOR DEL DATO';
COMMENT
ON COLUMN bluebank.MOVIMIENTOS.CUE_ID IS 'IDENTIFICADOR DEL DATO';
COMMENT
ON COLUMN bluebank.MOVIMIENTOS.MOV_FECHA IS 'FECHA EN QUE SE REALIZO';
COMMENT
ON COLUMN bluebank.MOVIMIENTOS.MOV_TIPO IS 'TIPO DE MOVIMIENTO R:RETIRO C:CONSIGNACION';
COMMENT
ON COLUMN bluebank.MOVIMIENTOS.MOV_VALOR IS 'VALOR DEL MOVIMIENTO';
COMMENT
ON COLUMN bluebank.MOVIMIENTOS.CIU_ID IS 'CIUDAD DONDE SE REALIZO';


ALTER SEQUENCE bluebank.movimientos_mov_id_seq OWNED BY bluebank.MOVIMIENTOS.MOV_ID;

ALTER TABLE bluebank.CUENTA
    ADD CONSTRAINT ciu_cue_fk
        FOREIGN KEY (CIU_ID)
            REFERENCES bluebank.CIUDADES (CIU_ID)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;

ALTER TABLE bluebank.MOVIMIENTOS
    ADD CONSTRAINT ciu_mov_fk
        FOREIGN KEY (CIU_ID)
            REFERENCES bluebank.CIUDADES (CIU_ID)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;

ALTER TABLE bluebank.CUENTA
    ADD CONSTRAINT cli_cue_fk
        FOREIGN KEY (CLI_ID)
            REFERENCES bluebank.CLIENTE (CLI_ID)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;

ALTER TABLE bluebank.MOVIMIENTOS
    ADD CONSTRAINT cuenta_movimientos_fk
        FOREIGN KEY (CUE_ID)
            REFERENCES bluebank.CUENTA (CUE_ID)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
            NOT DEFERRABLE;