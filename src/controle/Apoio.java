package controle;


import java.io.File;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andre
 */
public class Apoio {

    public String cpfEntrada(String cpf)
    {

        int i=0;
        String cpf2="",cpf3="", teste="";


        for(i=0;i<cpf.length();i++)
        {
            teste=String.valueOf(cpf.charAt(i));


            if(teste.equals("."))
            {
            cpf2 = cpf.substring(0, i);
            cpf3 = cpf.substring(i+1, cpf.length());
            cpf = cpf2+cpfEntrada(cpf3);
            return cpf;
            }

            if(teste.equals("-"))
            {
            cpf2 = cpf.substring(0, i);
            cpf3 = cpf.substring(i+1, cpf.length());
            cpf = cpf2+cpfEntrada(cpf3);
            return cpf;
            }



        }


        return cpf;
    }


    public String dataEntrada(String data)
    {
        int i=0;
        String data2="",data3="", teste="";


        for(i=0;i<data.length();i++)
        {
            teste=String.valueOf(data.charAt(i));

            if(teste.equals("/"))
            {
            data2 = data.substring(0, i);
            data3 = data.substring(i+1, data.length());
            if(data2.length()==1)
       {
           data2 = "0"+data2;
       }
            data = data2+dataEntrada(data3);
            return data;
            }

            if(teste.equals(File.separator))
            {
            data2 = data.substring(0, i);
            data3 = data.substring(i+1, data.length());
            if(data2.length()==1)
       {
           data2 = "0"+data2;
       }
            data = data2+dataEntrada(data3);
            return data;
            }

        }

        return data;
    }

    public String dataEntrada2(String data)
    {
    if(data.length()==8)
    {
       String dia, mes, ano;

       dia = data.substring(0, 2);

       mes = data.substring(2, 4);

       ano = data.substring(4);

       data = ano + "-" + mes + "-" + dia;

    }

        return data;
    }



    public String cpfSaida(String cpf)
    {

        if(cpf.length()==11)
        {
            cpf = cpf.substring(0, 3)+"."+cpf.substring(3, 6)+"."+cpf.substring(6, 9)+"-"+cpf.substring(9);
        }


        return cpf;
    }


    public String dataSaida(String data)
    {

        if(data.length()==10)
        {
            String dia, mes, ano;

            ano = data.substring(0, 4);

            mes = data.substring(5, 7);

            dia = data.substring(8);

            data = dia + "/" + mes + "/" + ano;
        }

        if(data.length()==8)
        {
            String dia, mes, ano;

            dia = data.substring(0, 2);

            mes = data.substring(2, 4);

            ano = data.substring(4);

            data = dia + "/" + mes + "/" + ano;
        }

        return data;
    }

    public String dinheiroEntrada(String real)
    {

        int i;

        String teste;
        String realInteiro, realCentavos;

        for(i=0;i<real.length();i++)
        {
            teste=String.valueOf(real.charAt(i));


            if(teste.equals("."))
            {
                if(real.substring(i).length()<=3)
                {
            realInteiro = real.substring(0, i);
            realCentavos = real.substring(i+1, real.length());
            if(realCentavos.length()==2)
            {

            }
            else
            {
                realCentavos = real.substring(i+1, i+2);
                realCentavos = realCentavos + "0";
            }
            real = realInteiro+"."+realCentavos;
            return real;
                }
                else
                {
                    real = dinheiroEntrada(real.substring(0,i)+real.substring(i+1));
                }
            }

            if(teste.equals(","))
            {
            realInteiro = real.substring(0, i);
            realCentavos = real.substring(i+1, real.length());
            if(realCentavos.length()==2)
            {

            }
            else
            {
                realCentavos = real.substring(i+1, i+2);
                realCentavos = realCentavos + "0";
            }
            real = realInteiro+"."+realCentavos;
            return real;
            }



        }

        return real;

    }

    public String dinheiroSaida(String real)
    {
        int i;

        String teste;
        String realInteiro, realCentavos;

        for(i=0;i<real.length();i++)
        {
            teste=String.valueOf(real.charAt(i));


            if(teste.equals("."))
            {
            realInteiro = real.substring(0, i);
            realCentavos = real.substring(i+1, real.length());
            if(realCentavos.length()==2)
            {

            }
            else
            {
                realCentavos = real.substring(i+1, i+2);
                realCentavos = realCentavos + "0";
            }
            real = realInteiro+","+realCentavos;
            return real;
            }

            if(teste.equals(","))
            {
            realInteiro = real.substring(0, i);
            realCentavos = real.substring(i+1, real.length());
            if(realCentavos.length()==2)
            {

            }
            else
            {
                realCentavos = real.substring(i+1, i+2);
                realCentavos = realCentavos + "0";
            }
            real = realInteiro+","+realCentavos;
            return real;
            }



        }

        return real;

    }




}
