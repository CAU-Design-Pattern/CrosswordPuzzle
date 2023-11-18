package repository;

import com.holub.database.Cursor;
import com.holub.database.Database;
import com.holub.database.Table;
import com.holub.text.ParseFailure;
import dto.Account;
import dto.Word;
import exception.UniqueFailException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepository {
    private Database database;

    public AccountRepository(Database database) {
        this.database = database;
    }

    public Account getOneAccountById(String id) throws IOException, ParseFailure {
        String sql = "select * from account where id = '" + id + "'";
        Table table = database.execute(sql);
        Cursor cursor = table.rows();
        List<Account> accountList = transferAccountList(cursor);
        if(accountList.isEmpty()) return null;
        return accountList.get(0);
    }

    public void insertOneAccount(Account account) throws IOException, ParseFailure, UniqueFailException {
        Account existAccount = getOneAccountById(account.getId());
        if(existAccount != null) throw new UniqueFailException();
        String sql = "insert into account values ('" + account.getId() + "', '" + account.getPassword() +"', " + account.getLevel() +")";
        database.execute(sql);
        database.dump();
    }

    private List<Account> transferAccountList(Cursor cursor){
        List<Account> res = new ArrayList<>();
        int columnCnt = cursor.columnCount();
        while(cursor.advance()){
            Map<String, Object> rowMap = new HashMap<>();
            for(int i = 0; i < columnCnt; i++) {
                String columnName = cursor.columnName(i);
                Object value = cursor.column(columnName);
                rowMap.put(columnName, value);
            }
            res.add(new Account(rowMap));
        }
        return res;
    }
}
