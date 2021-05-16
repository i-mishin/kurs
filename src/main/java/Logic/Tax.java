package Logic;

public class Tax {
    public int taxId;
    public String taxcategory;
    public String month;
    public String income;
    public String single;
    public String simplyfied;

    public Tax() {

    }

    public int getTaxId() {
        return taxId;
    }

    public void settaxId(int taxId) {
        this.taxId = taxId;
    }

    public String getTaxcategory() {
        return taxcategory;
    }

    public void setTaxcategory(String taxcategory) {
        this.taxcategory = taxcategory;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    public String getSimplyfied() {
        return simplyfied;
    }

    public void setSimplyfied(String simplyfied) {
        this.simplyfied = simplyfied;
    }
}
