package Logic;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends Configs {
    public static final String USER_TABLE = "users";

    public static final String USERS_ID = "idusers";
    public static final String USER_LOGIN = "login";
    public static final String USER_PASSWORD = "password";
    public static final String USER_ACCESS = "access";

    public static final String TAX_TABLE = "taxes";

    public static final String TAX_ID = "idtax";
    public static final String TAX_CATEGORY = "taxcategory";
    public static final String TAX_MONTH = "month";
    public static final String TAX_INCOME = "income";
    public static final String TAX_SINGLE = "single";
    public static final String TAX_SIMPLIFYED = "simplyfied";

    public static final String FIRM_TABLE = "firms";
    public static final String FIRM_FORMA = "form";
    public static final String FIRM_WORKERS = "workers";
    public static final String FIRM_EARNING = "earning";

    public static final String RATE_TABLE = "rates";
    public static final String RATE_YEAR = "year";
    public static final String RATE_INCOME = "income";
    public static final String RATE_VAT = "vat";
    public static final String RATE_SIMPLYFIED = "simplyfied";
    public static final String RATE_PROFITIP = "profitIP";
    public static final String RATE_PROFITF = "profitF";

    public static final String DECLARE_TABLE = "declar";
    public static final String DECLARE_ID = "iddeclar";
    public static final String DECLARE_NUMBER = "number";
    public static final String DECLARE_NAME = "name";
    public static final String DECLARE_SURNAME = "surname";
    public static final String DECLARE_TITLE = "title";
    public static final String DECLARE_NALOG = "nalog";
    public static final String DECLARE_INCOME = "income";
    public static final String DECLARE_COSTS = "costs";
    public static final String DECLARE_FISCAL = "fiscal";


    //public static final String TAX_NUMBER = "number";

    public static Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName + "?" + "autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.jdbc.Driver");
        Connection dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        return dbConnection;
    }

    public static boolean userAdd(String reglogin, String regpassword) throws IOException, ClassNotFoundException, SQLException {
        ResultSet resSet = null;
        boolean flag = true;

        /*System.out.println("login: " + reglogin + " ");
        System.out.println("pw: " + regpassword + " ");*/


        String select = "SELECT * FROM " + USER_TABLE + " WHERE " + USER_LOGIN + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, reglogin);
            resSet = prSt.executeQuery();
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        if(resSet != null && resSet.next())
        {
            flag = false;
        }
        else {
            String insert = "INSERT INTO " + USER_TABLE + "(" +
                    USER_LOGIN + "," + USER_PASSWORD + ")" +
                    "VALUES(?, ?)";
            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(insert);
                prSt.setString(1, reglogin);
                prSt.setString(2, regpassword);
                prSt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public static boolean adminEnter(String adminlogin, String adminpassword) throws SQLException, ClassNotFoundException {
        Statement statement = getDbConnection().createStatement();
        boolean result = false;

        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + USER_TABLE);
        while(resultSet.next()){
            String logCheck = resultSet.getString(2);
            String passCheck = resultSet.getString(3);
            int accessCheck = resultSet.getInt(4);
            if(adminlogin.equals(logCheck) && adminpassword.equals(passCheck) && accessCheck == 1)
            {
                result = true;
            }
            //System.out.println(result);
        }
        return result;
    }

    public static boolean userEnter(String userlogin, String userpassword) throws SQLException, ClassNotFoundException {
        Statement statement = getDbConnection().createStatement();
        boolean result = false;

        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + USER_TABLE);
        while(resultSet.next()){
            String logCheck = resultSet.getString(2);
            String passCheck = resultSet.getString(3);
            int accessCheck = resultSet.getInt(4);
            if(userlogin.equals(logCheck) && userpassword.equals(passCheck) && accessCheck == 0)
            {
                result = true;
            }
            //System.out.println(result);
        }
        return result;
    }

    public static String recordAdd(String category, String month, String income, String single, String simplyfied, String number){

        ResultSet resSet = null;

        String insert = "INSERT INTO " + TAX_TABLE + "(" +
                TAX_CATEGORY + "," + TAX_MONTH + "," + TAX_INCOME + "," + TAX_SINGLE + "," + TAX_SIMPLIFYED + ")" +
                "VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, category);
            prSt.setString(2, month);
            prSt.setString(3, income);
            prSt.setString(4, single);
            prSt.setString(5, simplyfied);
            prSt.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        String statement = "Данные записаны успешно";
        return statement;
    }

    public static boolean delUser(String delLogin) throws SQLException {
        ResultSet resSet = null;
        boolean result;
        int resSet1;
        String select = " ";

        String selectCheck = "SELECT * FROM " + USER_TABLE + " WHERE " + USER_LOGIN + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(selectCheck);
            prSt.setString(1, delLogin);
            resSet = prSt.executeQuery();
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        if(resSet != null && resSet.next()) {
            select = "DELETE FROM " + USER_TABLE + " WHERE " + USER_LOGIN + "=?";
            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(select);
                prSt.setString(1, delLogin);
                resSet1 = prSt.executeUpdate();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            result = true;
        }
        else{
            result = false;
        }

        return result;
    }

    public static boolean delRecord(String id) throws SQLException {
        ResultSet resSet = null;
        boolean result;
        int resSet1;
        String select = " ";

        String selectCheck = "SELECT * FROM " + TAX_TABLE + " WHERE " + TAX_ID + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(selectCheck);
            prSt.setString(1, id);
            resSet = prSt.executeQuery();
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        if(resSet != null && resSet.next()) {

            select = "DELETE FROM " + TAX_TABLE + " WHERE " + TAX_ID + "=?";

            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(select);
                prSt.setString(1, id);
                resSet1 = prSt.executeUpdate();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            result = true;
        }
        else{
            result = false;
        }

        return result;
    }

    public static String fiscalStat() throws SQLException, ClassNotFoundException {
        double resultIncome = 0;
        double resultSingle = 0;
        double resultSimplyfied = 0;
        double sum = 0;

        Statement statementIncome = getDbConnection().createStatement();

        ResultSet resultSetIncome = statementIncome.executeQuery("SELECT * FROM " + TAX_TABLE + " WHERE " + TAX_INCOME);
        while(resultSetIncome.next()){
            sum += resultSetIncome.getDouble(4);
        }

        Statement statementSingle = getDbConnection().createStatement();

        ResultSet resultSetSingle = statementSingle.executeQuery("SELECT * FROM " + TAX_TABLE + " WHERE " + TAX_SINGLE);
        while(resultSetSingle.next()){
            resultSingle += resultSetSingle.getDouble(5);
        }

        Statement statementSimplyfied = getDbConnection().createStatement();

        ResultSet resultSetSimplyfied = statementSimplyfied.executeQuery("SELECT * FROM " + TAX_TABLE + " WHERE " + TAX_SIMPLIFYED);
        while(resultSetSimplyfied.next()){
            resultSimplyfied += resultSetSimplyfied.getDouble(6);
        }

        String incomeSum = Double.toString(sum);
        String singleSum = Double.toString(resultSingle);
        String simplyfiedSum = Double.toString(resultSimplyfied);

        String result = incomeSum + "|" + singleSum + "|" + simplyfiedSum;
        return result;
    }

    //// RESULTSET на пустоту
    public static ResultSet getRecords() throws SQLException {
        ResultSet resSet = null;
        String select = " ";
        select = "SELECT *" + " FROM " + TAX_TABLE;

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resSet = prSt.executeQuery();
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        String arr = "";

        return resSet;
    }

    ///////////////// ПРОВЕРКА
    public static String findRecord(String id) throws SQLException {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + TAX_TABLE + " WHERE " + TAX_ID + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, id);
            resSet = prSt.executeQuery();
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        String arr = "";
        while (resSet.next()) {
            String a =
                    resSet.getString("idtax") + "  " +
                            resSet.getString("taxcategory") + "  " +
                            resSet.getString("month") + "  " +
                            resSet.getString("income") + "  " +
                            resSet.getString("single") + "  " +
                            resSet.getString("simplyfied");
            arr += a;
        }
        //System.out.println("array: " + arr);
        return arr;
    }

    public static String categoryStat() throws SQLException, ClassNotFoundException {
       ResultSet resSet = null;
       String selectCitizen = " ";
       String selectIE = " ";

       selectCitizen = "SELECT " + TAX_INCOME + "," + TAX_SINGLE + "," + TAX_SIMPLIFYED +
                " FROM " + TAX_TABLE + " WHERE " + TAX_CATEGORY + "='citizens'";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(selectCitizen);
            resSet = prSt.executeQuery();
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        String sumCitizens = "";
        while (resSet.next()) {
               String arr =  resSet.getString("income") + " " +
               resSet.getString("single") + " " +
               resSet.getString("simplyfied") + " ";

               sumCitizens += arr;
        }

        String[] arrCitizens = sumCitizens.split(" ");
        double citizenSum = 0;
        double numArr[] = new double[arrCitizens.length];
        for (int i = 0; i < arrCitizens.length; i++) {
            numArr[i] = Double.parseDouble(arrCitizens[i]);
            citizenSum += numArr[i];
        }

        selectIE = "SELECT " + TAX_INCOME + "," + TAX_SINGLE + "," + TAX_SIMPLIFYED +
                " FROM " + TAX_TABLE + " WHERE " + TAX_CATEGORY + "='ie'";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(selectIE);
            resSet = prSt.executeQuery();
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        String sumIE = "";
        while (resSet.next()) {
            String arr =  resSet.getString("income") + " " +
                    resSet.getString("single") + " " +
                    resSet.getString("simplyfied") + " ";

            sumIE += arr;
        }

        String[] arrIE = sumIE.split(" ");
        double[] arrayIE = null;
        double IESum = 0;
        double numArr1[] = new double[arrIE.length];
        for (int i = 0; i < arrIE.length; i++) {
            numArr1[i] = Double.parseDouble(arrIE[i]);
            IESum += numArr1[i];
        }

        String strCitizens = Double.toString(citizenSum);
        String strIE = Double.toString(IESum);

        String catResult = strCitizens + " " + strIE;
        return catResult;
    }

    public static boolean firstRedact(String redID) throws SQLException {
        ResultSet resSet = null;
        boolean result;
        int resSet1;
        String select = " ";

        String selectCheck = "SELECT * FROM " + TAX_TABLE + " WHERE " + TAX_ID + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(selectCheck);
            prSt.setString(1, redID);
            resSet = prSt.executeQuery();
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        if (resSet != null && resSet.next())
        {
            select = "DELETE FROM " + TAX_TABLE + " WHERE " + TAX_ID + "=?";

            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(select);
                prSt.setString(1, redID);
                resSet1 = prSt.executeUpdate();
            }
            catch(SQLException | ClassNotFoundException e){
                e.printStackTrace();
            }
            result = true;
        }
        else{
            result = false;
        }
        return result;
    }

    public static List taxCheck(String forma, String workers, String vv){
        int result = 0;
        ResultSet resSet = null;
        List taxes = new ArrayList();

        String insert = "INSERT INTO " + FIRM_TABLE + "(" +
                FIRM_FORMA + "," + FIRM_WORKERS + "," + FIRM_EARNING + ")" +
                "VALUES(?, ?, ?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, forma);
            prSt.setString(2, workers);
            prSt.setString(3, vv);
            prSt.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        double earning = Double.parseDouble(vv);
        double wks = Double.parseDouble(workers);

        if(forma.equals("ИП") && earning < 315000)
        {
            FirmTaxes tax = new FirmTaxes();
            tax.setSingleTax("Допустим при определённых видах деятельности");
            tax.setCommonTax("Допустима");
            tax.setSimplyfiedTax("Оптимальна");
            tax.setProfitTax("5% без НДС или 3% с НДС");
            tax.setVat("При упрощённой системе с 3%");
            tax.setInsuranceTax("Не подлежит уплате");
            tax.setSwf("Не подлежит уплате");
            tax.setIncomeTax("Не подлежит уплате");

            taxes.add(tax);
        }
        else if(forma.equals("ИП") && earning > 315000){
            FirmTaxes tax = new FirmTaxes();
            tax.setSingleTax("Допустим при определённых видах деятельности");
            tax.setCommonTax("Подлежит уплате");
            tax.setSimplyfiedTax("Недопустима");
            tax.setProfitTax("Подлежит уплате");
            tax.setVat("Подлежит уплате (20%)");
            tax.setInsuranceTax("Подлежит уплате");
            tax.setSwf("Подлежит уплате");
            tax.setIncomeTax("Подлежит уплате");

            taxes.add(tax);
        }

        if(!forma.equals("ИП") && earning < 1465565 || wks < 100){
            FirmTaxes tax = new FirmTaxes();
            tax.setSingleTax("Недопустим");
            tax.setCommonTax("Допустима");
            tax.setSimplyfiedTax("Оптимальна");
            tax.setProfitTax("5% с НДС или 3% с НДС");
            tax.setVat("При упрощённой системе с 3%");
            tax.setInsuranceTax("Подлежит уплате");
            tax.setSwf("Подлежит уплате");
            tax.setIncomeTax("Не подлежит уплате");

            taxes.add(tax);
        }

        if(!forma.equals("ИП") && earning > 1465565 || wks > 100){
            FirmTaxes tax = new FirmTaxes();
            tax.setSingleTax("Недопустим");
            tax.setCommonTax("Недопустима");
            tax.setSimplyfiedTax("Допустима");
            tax.setProfitTax("Подлежит уплате");
            tax.setVat("Подлежит к уплате (20%)");
            tax.setInsuranceTax("Подлежит уплате");
            tax.setSwf("Подлежит уплате");
            tax.setIncomeTax("Подлежит уплате");

            taxes.add(tax);
        }

        return taxes;
    }

    public static List declare(String number, String name, String surname, String title, String nalog, String income, String costs, String vat, String reg) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\Kurs\\src\\main\\resources\\Accounts.txt"));
        String line;
        List<String> lines = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        String [] arr = lines.toArray(new String[lines.size()]);
        ////////////////////////////////////////////////////////
        ResultSet resSet = null;
        String fiscal = " ";

        String insertRates = "INSERT INTO " + RATE_TABLE + "(" +
                RATE_YEAR + "," +
                RATE_INCOME + "," +
                RATE_VAT + "," +
                RATE_SIMPLYFIED + "," +
                RATE_PROFITIP + "," +
                RATE_PROFITF + ")" +
                "VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insertRates);
            prSt.setString(1, arr[0]);
            prSt.setString(2, arr[1]);
            prSt.setString(3, arr[2]);
            prSt.setString(4, arr[3]);
            prSt.setString(5, arr[4]);
            prSt.setString(6, arr[5]);
            prSt.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        List declare = new ArrayList();

        if(nalog.equals("Упрощённая система (УСН)") && Double.parseDouble(vat) == 0){
            declare = simplyfied(income);
        }
        else if(Double.parseDouble(vat) > 0){
            declare = simplyfiedVAT(income, vat);
        }

        if(nalog.equals("Общая система (ОСН)") && reg.equals("Физическое лицо")){
            int status = 1;
            declare = common(status, income, costs, vat);
        }
        else if(reg.equals("Юридическое лицо")){
            int status = 0;
            declare = common(status, income, costs, vat);
        }

        if(nalog.equals("Общая система (ОСН)") && Double.parseDouble(vat) == 0){
            declare = error();
        }

        String insert = "INSERT INTO " + DECLARE_TABLE + "(" +
                DECLARE_NUMBER + "," +
                DECLARE_NAME + "," +
                DECLARE_SURNAME + "," +
                DECLARE_TITLE + "," +
                DECLARE_NALOG + "," +
                DECLARE_INCOME + "," +
                DECLARE_COSTS + "," +
                DECLARE_FISCAL + ")" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement prSt2 = getDbConnection().prepareStatement(insert);
            prSt2.setString(1, number);
            prSt2.setString(2, name);
            prSt2.setString(3, surname);
            prSt2.setString(4, title);
            prSt2.setString(5, nalog);
            prSt2.setString(6, income);
            prSt2.setString(7, costs);
            prSt2.setString(8, "9");
            prSt2.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return declare;
    }

    public static List simplyfied(String income){
        Double simplySum = Double.parseDouble(income) * 0.05;
        List bufList = new ArrayList();
        bufList.add("Статус: Декларация подана");
        bufList.add("К уплате по упрощённой системе без НДС: " + simplySum + "BYN");

        return bufList;
    }

    public static List simplyfiedVAT(String income, String vat){
        Double simplySum = Double.parseDouble(income) * 0.03;
        Double vatSum = Double.parseDouble(vat) * 0.2;
        List bufList = new ArrayList();
        bufList.add("Статус: Декларация подана");
        bufList.add("К уплате по упрощённой системе с НДС: " + simplySum + "BYN");
        bufList.add("НДС к уплате: " + vatSum + "BYN");
        return bufList;
    }

    public static List common(int status, String income, String costs, String vat){
        Double profitSum = 0.0;
        Double vatSum = Double.parseDouble(vat) * 0.2;
        Double profit = Double.parseDouble(income) - Double.parseDouble(costs);
        if (status == 1) {
            profitSum = profit * 0.16;
        }
        else{
            profitSum = profit * 0.18;
        }
        List bufList = new ArrayList();
        bufList.add("Статус: Декларация подана");
        bufList.add("К уплате: налог на прибыль: " + profitSum + "BYN");
        bufList.add("НДС к уплате: " + vatSum + "BYN");
        return bufList;
    }

    public static List error(){
        List bufList = new ArrayList();
        bufList.add("Статус: Ошибка в подаче декларации");
        bufList.add("Отстуствует налогооблагаемая база НДС при общей системе налогообложения");
        return bufList;
    }

    public static ResultSet getDeclare(){
        ResultSet resSet = null;
        String select = " ";
        select = "SELECT *" + " FROM " + DECLARE_TABLE;

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resSet = prSt.executeQuery();
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        String arr = "";

        return resSet;
    }

    public static boolean declined(String decID) throws SQLException {
        ResultSet resSet = null;
        boolean result;
        int resSet1;
        String select = " ";

        String selectCheck = "SELECT * FROM " + DECLARE_TABLE + " WHERE " + DECLARE_ID + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(selectCheck);
            prSt.setString(1, decID);
            resSet = prSt.executeQuery();
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        if(resSet != null && resSet.next()) {

            select = "DELETE FROM " + DECLARE_TABLE + " WHERE " + DECLARE_ID + "=?";

            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(select);
                prSt.setString(1, decID);
                resSet1 = prSt.executeUpdate();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            result = true;
        }
        else{
            result = false;
        }

        return result;
    }

    public static String numCheck(String unp) throws SQLException {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + DECLARE_TABLE + " WHERE " + DECLARE_NUMBER + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, unp);
            resSet = prSt.executeQuery();
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        String arr = "";
        while (resSet.next()) {
            String a =
                    resSet.getString("iddeclar") + "*" +
                            resSet.getString("number") + "*" +
                            resSet.getString("name") + "*" +
                            resSet.getString("surname") + "*" +
                            resSet.getString("title") + "*" +
                            resSet.getString("nalog") + "*" +
                            resSet.getString("income") + "*" +
                            resSet.getString("costs") + "*" +
                            resSet.getString("fiscal");
            arr += a;
        }
        //System.out.println("array: " + arr);


        /*if(resSet != null && resSet.next()) {

            select = "DELETE FROM " + TAX_TABLE + " WHERE " + TAX_ID + "=?";

            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(select);
                prSt.setString(1, id);
                resSet1 = prSt.executeUpdate();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            result = true;
        }
        else{
            result = false;
        }*/

        return arr;
    }
}
