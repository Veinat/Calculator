package com.veinat.calculated.Converter;

public class Converting {



    //class to convert units of length
    static class Length{
        public double MilliToMeter(double milli)
        {
            return (milli/1000);
        }

        public double MeterToMilli(double meter)
        {
            return (meter*1000);
        }

        public double CentiToMeter(double Centi)
        {
            return (Centi/100);
        }

        public double MeterToCenti(double meter)
        {
            return (meter*100);
        }

        public double KiloToMeter(double Kilo)
        {
            return (Kilo*1000);
        }

        public double MeterToKilo(double meter)
        {
            return (meter/1000);
        }

        public double FootToMeter(double Foot)
        {
            return (Foot/3.28084);
        }

        public double MeterToFoot(double meter)
        {
            return (meter*3.28084);
        }

        public double MileToMeter(double Mile)
        {
            return (Mile/0.000621371);
        }

        public double MeterToMile(double meter)
        {
            return (meter*0.000621371);
        }

        public double NanoToMeter(double milli)
        {
            return (milli/1000000000);
        }

        public double MeterToNano(double meter)
        {
            return (meter*1000000000);
        }

    }

    //class to convert units of temperature
    static class Temperature{
        public double FerToKelvin(double fer)
        {
            return ((fer+459.67)*5/9);
        }

        public double KelvinToFer(double kelvin)
        {
            return ((kelvin*9/5)-459.67);
        }

        public double CelsiTokelvin(double Celsi)
        {
            return (Celsi+273.15);
        }

        public double KelvinToCelsi(double Kelvin)
        {
            return (Kelvin-273.15);
        }
    }

    //class to convert units of mass/weight
    static class Weight
    {
        public double MilliToKilo(double milli)
        {
            return (milli/1000000);
        }

        public double KiloToMilli(double Kilo)
        {
            return (Kilo*1000000);
        }

        public double GramToKilo(double Gram)
        {
            return (Gram/1000);
        }

        public double KiloToGram(double Kilo)
        {
            return (Kilo*1000);
        }

        public double MetricTonnesToKilo(double MetricTonnes)
        {
            return (MetricTonnes*1000);
        }

        public double KiloToMetricTonnes(double Kilo)
        {
            return (Kilo/1000);
        }
    }
}