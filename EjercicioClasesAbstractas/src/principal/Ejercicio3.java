package principal;

public abstract class Unidad {
    protected String nombre;
    protected int vida;
    protected int ataque;
    protected int defensa;
    protected boolean viva;
    
    public Unidad(String nombre, int vida, int ataque, int defensa) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.viva = true;
    }
    
    public void atacar(Unidad objetivo) {
        if (!this.viva) {
            System.out.println(this.nombre + " está muerta y no puede atacar.");
            return;
        }
        
        if (!objetivo.viva) {
            System.out.println(objetivo.nombre + " ya está muerta.");
            return;
        }
        
        System.out.println("\n⚔️  " + this.nombre + " ataca a " + objetivo.nombre);
        objetivo.recibirDanio(this.ataque);
    }
    
    public void recibirDanio(int danioRecibido) {
        int danioReal = Math.max(0, danioRecibido - this.defensa);
        this.vida -= danioReal;
        
        System.out.println("   💥 Daño recibido: " + danioReal + " (Ataque: " + danioRecibido + " - Defensa: " + this.defensa + ")");
        System.out.println("   ❤️  Vida restante de " + this.nombre + ": " + Math.max(0, this.vida));
        
        if (this.vida <= 0) {
            this.vida = 0;
            this.viva = false;
            System.out.println("   ☠️  " + this.nombre + " ha sido eliminada!");
        }
    }
    
    public abstract void mostrarInformacion();
    
    public boolean estaViva() {
        return viva;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }
}