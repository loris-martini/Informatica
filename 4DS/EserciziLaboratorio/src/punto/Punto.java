package punto;

public class Punto {
        private float x;
        private float y;

        public Punto(float x, float y){
            this.x = x;
            this.y = y;
        }

        public Punto(Punto p){
            this.x = p.x;
            this.y = p.y;
        }

        public float getX(){
            return x;
        }

        public void setX(float x){
            this.x = x;
        }

        public float getY(){
            return y;
        }

        public void setY(float y){
            this.y = y;
        }

        public void shift(float dX, float dY){
            x += dX;
            y += dY;
        }

        public String toString(){
            return "(" + x + "," + y + ")";
        }
    }
