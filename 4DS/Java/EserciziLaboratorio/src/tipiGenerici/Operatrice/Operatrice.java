package tipiGenerici.Operatrice;

import java.awt.*;

public class Operatrice <T> {
    private T v1;
    private T v2;

    public Operatrice (){

    }

    public Operatrice (T val1, T val2) throws Exception{
        setV1(val1);
        setV2(val2);
    }

    public T getV1() {
        return v1;
    }

    public T getV2() {
        return v2;
    }

    public void setV1(T v1) throws Exception{
        if(v1 == null){
            throw new Exception("Valore nullo!");
        }
        this.v1 = v1;
    }

    public void setV2(T v2) throws Exception{
        if(v1 == null){
            throw new Exception("Valore nullo!");
        }
        this.v2 = v2;
    }

    public T somma() throws Exception{
        if(controllo()){
            if(v1 instanceof Integer){
                Integer s = (Integer)v1 + (Integer)v2;
                return (T)s;
            }else if(v1 instanceof Float){
                Float s = (Float) v1 + (Float)v2;
                return (T)s;
            }else if(v1 instanceof Double){
                Double s = (Double) v1 + (Double) v2;
                return (T)s;
            }else if(v1 instanceof Long){
                Long s = (Long) v1 + (Long) v2;
                return (T)s;
            }else if(v1 instanceof Boolean){
                Boolean s = (Boolean)v1 || (Boolean)v2;
                return (T)s;
            }else{
                String s = String.valueOf(v1) + "\n" + String.valueOf(v2);
                return (T)s;
            }
        }
        throw new Exception("Impossibile eseguire la somma!");
    }

    private boolean controllo(){
        if(v1.getClass() == v2.getClass() ){
            return true;
        }
        return false;
    }


    public T sottrazione() throws Exception{
        if(controllo()){
            if(v1 instanceof Integer){
                Integer s = (Integer)v1 - (Integer)v2;
                return (T)s;
            }else if(v1 instanceof Float){
                Float s = (Float) v1 - (Float)v2;
                return (T)s;
            }else if(v1 instanceof Double){
                Double s = (Double) v1 - (Double) v2;
                return (T)s;
            }else if(v1 instanceof Long){
                Long s = (Long) v1 - (Long) v2;
                return (T)s;
            }else if(v1 instanceof Boolean){
                throw new Exception("Impossibile eseguire la sottrazione!");
            }
        }
        throw new Exception("Impossibile eseguire la sottrazione!");
    }

    public T moltiplicazione() throws Exception{
        if(controllo()){
            if(v1 instanceof Integer){
                Integer s = (Integer)v1 * (Integer)v2;
                return (T)s;
            }else if(v1 instanceof Float){
                Float s = (Float) v1 * (Float)v2;
                return (T)s;
            }else if(v1 instanceof Double){
                Double s = (Double) v1 * (Double) v2;
                return (T)s;
            }else if(v1 instanceof Long){
                Long s = (Long) v1 * (Long) v2;
                return (T)s;
            }else if(v1 instanceof Boolean){
                Boolean s = (Boolean)v1 && (Boolean)v2;
                return (T)s;
            }
        }
        throw new Exception("Impossibile eseguire la moltiplicazione!");
    }

    public T divisione() throws Exception{
        if(controllo()){
            if(v1 instanceof Integer){
                if((Integer)v2 == 0){
                    throw new Exception("Non si può dividere per 0!");
                }
                Integer s = (Integer)v1 / (Integer)v2;
                return (T)s;
            }else if(v1 instanceof Float){
                if((Float)v2 == 0){
                    throw new Exception("Non si può dividere per 0!");
                }
                Float s = (Float) v1 / (Float)v2;
                return (T)s;
            }else if(v1 instanceof Double){
                if((Double)v2 == 0){
                    throw new Exception("Non si può dividere per 0!");
                }
                Double s = (Double) v1 / (Double) v2;
                return (T)s;
            }else if(v1 instanceof Long){
                if((Long)v2 == 0){
                    throw new Exception("Non si può dividere per 0!");
                }
                Long s = (Long) v1 - (Long) v2;
                return (T)s;
            }else if(v1 instanceof Boolean){
                throw new Exception("Impossibile eseguire la divisione!");
            }
        }
        throw new Exception("Impossibile eseguire la divisione!");
    }

    public Class tipoVal1() throws Exception{
        if(v1 == null){
            throw new Exception("Valore nullo!");
        }
        return v1.getClass();
    }

    public Class tipoVal2() throws Exception{
        if(v1 == null){
            throw new Exception("Valore nullo!");
        }
        return v2.getClass();
    }

    public <T> T verificaTipo(T valore){
        return (T)valore.getClass();
    }

    public String toString(){
        return v1 + " : " + v2;
    }

}
