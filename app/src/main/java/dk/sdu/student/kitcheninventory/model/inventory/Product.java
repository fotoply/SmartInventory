package dk.sdu.student.kitcheninventory.model.inventory;

import android.media.Image;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Product implements Serializable {

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    private String name;
    private Image photo;
    private String category;
    private Date expirationDate;
    private double amount;
    private String amountSuffix;

    public String getAmountSuffix() {
        return amountSuffix;
    }

    public void setAmountSuffix(String amountSuffix) {
        this.amountSuffix = amountSuffix;
    }

    public Product applyTemplate(ProductTemplate template) {
        this.name = template.getName();
        this.category = template.getCategory();
        int expirationTime = (int) template.getExpirationTime();
        setExpirationInDays(expirationTime);
        this.amount = template.getAmount();
        return this;
    }

    public void setExpirationInDays(int expirationTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, expirationTime);
        this.expirationDate = new Date(cal.getTimeInMillis());
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getFormattedExpiration() {
        long diff = getDaysUntilExpiration();

        if (diff > 1) {
            return String.format("om %d dage.", diff);
        } else if (diff == 1) {
            return "i morgen.";
        } else {
            return "i dag.";
        }
    }

    public long getDaysUntilExpiration() {
        if (expirationDate == null) {
            return 0;
        }
        Date today = new Date();
        today.setHours(0);
        return TimeUnit.DAYS.convert(expirationDate.getTime() - today.getTime(), TimeUnit.MILLISECONDS);
    }

    public String getFormattedAmount() {
        return amount + amountSuffix;
    }

    @Override
    @NonNull
    public String toString() {
        return amount + "x " + name + " - Udløber " + getFormattedExpiration();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(DefaultTemplates.search("Let").toArray()));
        System.out.println(Arrays.toString(DefaultTemplates.search("let").toArray()));
        System.out.println(Arrays.toString(DefaultTemplates.search("mælk").toArray()));

        Product test = new Product();
        test.applyTemplate(DefaultTemplates.search("let").get(0));
        System.out.println(test);

    }
}
