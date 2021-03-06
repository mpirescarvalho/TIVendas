package com.ticonsultoria.tivendas.tivendas.BD;

import android.content.ContentValues;
import android.content.Context;

import com.ticonsultoria.tivendas.tivendas.model.Cliente;

/**
 * Created by Helder on 19/01/2018.
 */

public class ClienteDAO extends DAOBasico<Cliente> {

    public static final String NOME_TABELA = "clientes";
    public static final String COLUNA_ID_LOCAL = "id_local";
    public static final String COLUNA_ID_WEB = "id_web";
    public static final String COLUNA_EMAIL = "email";
    public static final String COLUNA_TELEFONE = "telefone";
    public static final String COLUNA_NOME_CLIENTE = "nome_cliente";
    public static final String COLUNA_CPF = "CPF";
    public static final String COLUNA_NOME_MERCADO = "nome_mercado";
    public static final String COLUNA_ATIVO = "ativo";
    public static final String COLUNA_EMP_CODIGO = "emp_codigo";
    public static final String COLUNA_LAST_SYNC = "last_sync";

    public static final String SCRIPT_CRIACAO_TABELA_CLIENTES = "CREATE TABLE " + NOME_TABELA + "("
            + COLUNA_ID_LOCAL + " INTEGER PRIMARY KEY autoincrement,"
            + COLUNA_ID_WEB + " INTEGER,"
            + COLUNA_NOME_CLIENTE + " TEXT,"
            + COLUNA_EMAIL + " TEXT,"
            + COLUNA_TELEFONE + " TEXT,"
            + COLUNA_CPF + " TEXT,"
            + COLUNA_NOME_MERCADO + " TEXT,"
            + COLUNA_ATIVO + " TEXT,"
            + COLUNA_EMP_CODIGO + " INTEGER,"
            + COLUNA_LAST_SYNC + " TEXT"
            + ")";

    public static final String SCRIPT_DELECAO_TABELA_CLIENTES =  "DROP TABLE IF EXISTS " + NOME_TABELA;

    private static ClienteDAO instance;

    public static ClienteDAO getInstance(Context context){
        if (instance == null)
            instance = new ClienteDAO(context);
        return instance;
    }

    public ClienteDAO(Context context) {
        super(context);
    }

    @Override
    public String getNomeColunaPrimaryKey() {
        return COLUNA_ID_LOCAL;
    }

    @Override
    public String getNomeTabela() {
        return NOME_TABELA;
    }

    @Override
    public String getNomeColunaAtivo() {
        return COLUNA_ATIVO;
    }

    @Override
    public String getNomeColunaEmpresa() {
        return COLUNA_EMP_CODIGO;
    }

    @Override
    public ContentValues entidadeParaContentValues(Cliente cliente) {
        ContentValues values = new ContentValues();
        if(cliente.getId() > 0) {
            values.put(COLUNA_ID_LOCAL, cliente.getId());
        }
        values.put(COLUNA_ID_WEB, cliente.getId_web());
        values.put(COLUNA_NOME_CLIENTE, cliente.getNome_cliente());
        values.put(COLUNA_EMAIL, cliente.getEmail());
        values.put(COLUNA_TELEFONE, cliente.getTelefone());
        values.put(COLUNA_CPF, cliente.getCpf());
        values.put(COLUNA_NOME_MERCADO, cliente.getNomeMercado());
        values.put(COLUNA_ATIVO, cliente.isAtivo());
        values.put(COLUNA_EMP_CODIGO, cliente.getEmp_codigo());
        values.put(COLUNA_LAST_SYNC, cliente.getLast_sync());

        return values;
    }

    @Override
    public Cliente contentValuesParaEntidade(ContentValues contentValues) {
        Cliente  cliente = new Cliente();
        cliente.setId(contentValues.getAsInteger(COLUNA_ID_LOCAL));
        if (contentValues.getAsInteger(COLUNA_ID_WEB) != null) {
            cliente.setId_web(contentValues.getAsInteger(COLUNA_ID_WEB));
        }
        cliente.setAtivo(contentValues.getAsString(COLUNA_ATIVO));
        cliente.setEmail(contentValues.getAsString(COLUNA_EMAIL));
        cliente.setTelefone(contentValues.getAsString(COLUNA_TELEFONE));
        cliente.setNome_cliente(contentValues.getAsString(COLUNA_NOME_CLIENTE));
        cliente.setNomeMercado(contentValues.getAsString(COLUNA_NOME_MERCADO));
        cliente.setCpf(contentValues.getAsString(COLUNA_CPF));
        cliente.setEmp_codigo(contentValues.getAsInteger(COLUNA_EMP_CODIGO));
        cliente.setLast_sync(contentValues.getAsString(COLUNA_LAST_SYNC));

        return cliente;
    }



}
