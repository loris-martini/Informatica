package documentoCom;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Data {
    private String data;
    private Integer giorno;
    private Integer mese;
    private Integer anno;

    public Data() {
        LocalDate dataOdierna = LocalDate.now();
        this.giorno = dataOdierna.getDayOfMonth();
        this.mese = dataOdierna.getMonthValue();
        this.anno = dataOdierna.getYear();
        this.data = dataOdierna.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public Data(String data) throws Exception {
        this.setData(data);
    }

    public Data(Integer giorno, Integer mese, Integer anno) throws Exception {
        try {
            String dataFormatoTesto = (giorno <= 9 ? "0" + giorno : giorno) + "/" + (mese <= 9 ? "0" + mese : mese) + "/" + anno;
            this.setData(dataFormatoTesto);
        } catch (NullPointerException var6) {
            throw new Exception("Uno o più parametri sono nulli!");
        }
    }

    public Data(Data data) {
        this.data = data.data;
        this.giorno = data.giorno;
        this.mese = data.mese;
        this.anno = data.anno;
    }

    public String getData() {
        return this.data;
    }

    public final void setData(String data) throws Exception {
        try {
            LocalDate localDate = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            this.data = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            this.giorno = localDate.getDayOfMonth();
            this.mese = localDate.getMonthValue();
            this.anno = localDate.getYear();
        } catch (NullPointerException var3) {
            throw new Exception("La data non può essere nulla!");
        } catch (DateTimeException var4) {
            throw new Exception("Data errata!");
        }
    }

    public Integer getGiorno() {
        return this.giorno;
    }

    public final void setGiorno(Integer giorno) throws Exception {
        try {
            LocalDate localDate = LocalDate.of(this.anno, this.mese, giorno);
            this.giorno = localDate.getDayOfMonth();
            this.data = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (NullPointerException var3) {
            throw new Exception("Il giorno non può essere nullo!");
        } catch (DateTimeException var4) {
            throw new Exception("Giorno errato!");
        }
    }

    public Integer getMese() {
        return this.mese;
    }

    public final void setMese(Integer mese) throws Exception {
        try {
            LocalDate localDate = LocalDate.of(this.anno, mese, this.giorno);
            this.mese = localDate.getMonthValue();
            this.data = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (NullPointerException var3) {
            throw new Exception("Il mese non può essere nullo!");
        } catch (DateTimeException var4) {
            throw new Exception("Mese errato!");
        }
    }

    public Integer getAnno() {
        return this.anno;
    }

    public final void setAnno(Integer anno) throws Exception {
        try {
            LocalDate localDate = LocalDate.of(anno, this.mese, this.giorno);
            this.anno = localDate.getYear();
            this.data = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (NullPointerException var3) {
            throw new Exception("Il giorno non può essere nullo!");
        } catch (DateTimeException var4) {
            throw new Exception("Giorno errato!");
        }
    }

    public String giornoDellaSettimana() {
        LocalDate localDate = LocalDate.of(this.anno, this.mese, this.giorno);
        String giornoSettimana = localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ITALY);
        return giornoSettimana;
    }

    public static Integer differenzaInGiorni(Data dataAntecedente, Data dataSuccessiva) throws Exception {
        try {
            LocalDate localDate1 = LocalDate.of(dataAntecedente.anno, dataAntecedente.mese, dataAntecedente.giorno);
            LocalDate localDate2 = LocalDate.of(dataSuccessiva.anno, dataSuccessiva.mese, dataSuccessiva.giorno);
            Long giorni = ChronoUnit.DAYS.between(localDate1, localDate2);
            return giorni.intValue();
        } catch (NullPointerException var5) {
            throw new Exception("Uno o più parametri sono nulli!");
        }
    }

    public static Integer differenzaInSettimane(Data dataAntecedente, Data dataSuccessiva) throws Exception {
        try {
            LocalDate localDate1 = LocalDate.of(dataAntecedente.anno, dataAntecedente.mese, dataAntecedente.giorno);
            LocalDate localDate2 = LocalDate.of(dataSuccessiva.anno, dataSuccessiva.mese, dataSuccessiva.giorno);
            Long settimane = ChronoUnit.WEEKS.between(localDate1, localDate2);
            return settimane.intValue();
        } catch (NullPointerException var5) {
            throw new Exception("Uno o più parametri sono nulli!");
        }
    }

    public static Integer differenzaInMesi(Data dataAntecedente, Data dataSuccessiva) throws Exception {
        try {
            LocalDate localDate1 = LocalDate.of(dataAntecedente.anno, dataAntecedente.mese, dataAntecedente.giorno);
            LocalDate localDate2 = LocalDate.of(dataSuccessiva.anno, dataSuccessiva.mese, dataSuccessiva.giorno);
            Long mesi = ChronoUnit.MONTHS.between(localDate1, localDate2);
            return mesi.intValue();
        } catch (NullPointerException var5) {
            throw new Exception("Uno o più parametri sono nulli!");
        }
    }

    public static Integer differenzaInAnni(Data dataAntecedente, Data dataSuccessiva) throws Exception {
        try {
            LocalDate localDate1 = LocalDate.of(dataAntecedente.anno, dataAntecedente.mese, dataAntecedente.giorno);
            LocalDate localDate2 = LocalDate.of(dataSuccessiva.anno, dataSuccessiva.mese, dataSuccessiva.giorno);
            Long anni = ChronoUnit.YEARS.between(localDate1, localDate2);
            return anni.intValue();
        } catch (NullPointerException var5) {
            throw new Exception("Uno o più parametri sono nulli!");
        }
    }

    public static String differenzaInGiorniMesiAnni(Data dataAntecedente, Data dataSuccessiva) throws Exception {
        try {
            LocalDate localDate1 = LocalDate.of(dataAntecedente.anno, dataAntecedente.mese, dataAntecedente.giorno);
            LocalDate localDate2 = LocalDate.of(dataSuccessiva.anno, dataSuccessiva.mese, dataSuccessiva.giorno);
            Integer anni = Period.between(localDate1, localDate2).getYears();
            Integer mesi = Period.between(localDate1, localDate2).getMonths();
            Integer giorni = Period.between(localDate1, localDate2).getDays();
            return giorni + "gg " + mesi + "mm " + anni + "aaaa";
        } catch (NullPointerException var7) {
            throw new Exception("Uno o più parametri sono nulli!");
        }
    }

    public String toString() {
        LocalDate localDate = LocalDate.of(this.anno, this.mese, this.giorno);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy");
        String giornoSettimana = localDate.format(formatter);
        return giornoSettimana;
    }
}
