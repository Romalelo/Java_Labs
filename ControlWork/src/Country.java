public class Country {

    public String countryName;
    public double health, incoming, infl, lifetime;

    public Country(){
        this.countryName = Reader.countryName.get(Reader.countryName.size() - 1);
        this.health = Reader.health.get(Reader.health.size() - 1);
        this.incoming = Reader.incoming.get(Reader.incoming.size() - 1);
        this.infl = Reader.infl.get(Reader.infl.size() - 1);
        this.lifetime = Reader.lifetime.get(Reader.lifetime.size() - 1);
        addCountryLifetime(this.countryName, this.lifetime);
        addCountryInflation(this.countryName, this.infl);
        addCountryIncoming(this.countryName, this.incoming);
    }

    public String getCountryName(){
        return this.countryName;
    }

    public double getHealth(){
        return this.health;
    }

    public double getIncoming(){
        return this.incoming;
    }

    public double getInfl(){
        return this.infl;
    }

    public double getLifetime(){
        return this.lifetime;
    }

    public static void MaxLifetimer(){
        MaxLifetime.lifetimeCounter();
    }

    public void addCountryLifetime(String countryName, double lifetime){
        MaxLifetime.addLifetime(countryName, lifetime);
    }

    public void addCountryInflation(String countryName, double inflation){
        InflationCounter.addInflation(countryName, inflation);
    }

    public void addCountryIncoming(String countryName, double incoming){
        Main.addIncome(countryName, incoming);
    }
}
