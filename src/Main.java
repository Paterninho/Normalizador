import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Main {

    private static Connection conexao;

    public static void main(String[] args) {
        conexao = new Conexao().abrirConexao();
        ArrayList<String> arrayTexto = buscar();
        ArrayList<Normaliza> arrayNormalizado = trataLote(arrayTexto);
        for (Normaliza normalizado : arrayNormalizado) {
            updateTexto(normalizado);
            System.out.println(String.format("Original: %s, Normalizado: %s", normalizado.getTexto(), normalizado.getTextoNormalizado()));
        }

    }


    public static ArrayList<String> buscar() {
        String comando = "select no_cidade from ubs_construcaonone ";
        ArrayList list = new ArrayList();

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(comando);
            while (rs.next()) {
                list.add(rs.getString("no_cidade"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public static void updateTexto(Normaliza normaliza) {
        String comando = "update ubs_construcaonone set no_cidade = '" + normaliza.getTextoNormalizado() + "' where no_cidade  = \""+ normaliza.getTexto()+"\"";
        System.out.println(comando);
        try {
            Statement stmt = conexao.createStatement();
            int updateCount = stmt.executeUpdate(comando);
            System.out.println(updateCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Normaliza> trataLote(ArrayList<String> lote) {

        ArrayList<Normaliza> loteTratado = new ArrayList();
        for (int i = 0; i < lote.size(); i++) {
            Normaliza normaliza = new Normaliza();
            normaliza.setTexto(lote.get(i));
            normaliza.setTextoNormalizado(trataTexto(lote.get(i)));
            loteTratado.add(normaliza);
        }
        return loteTratado;
    }


    public static String trataTexto(String conteudo) {
////        Converte o texto para caracteres minusculos
        conteudo = conteudo.toLowerCase();

//        remove espacos em branco no meio do texto e quebras de linha
        conteudo = conteudo.replaceAll("(\\t)", " ");
        conteudo = conteudo.replaceAll("(\\r)", " ");
        conteudo = conteudo.replaceAll("(\\n)", " ");
        conteudo = conteudo.replaceAll("  ", " ");
        conteudo = conteudo.replaceAll("  ", " ");
        conteudo = conteudo.replaceAll("  ", " ");

        //Padroniza o alfabeto
        conteudo = conteudo.replaceAll("z", "s");
        conteudo = conteudo.replaceAll("ss", "s");
        conteudo = conteudo.replaceAll("ç", "s");
        conteudo = conteudo.replaceAll("c", "s");
        conteudo = conteudo.replaceAll("u", "o");
        conteudo = conteudo.replaceAll("y", "i");
        conteudo = conteudo.replaceAll("w", "u");
        conteudo = conteudo.replaceAll("h", "");
        conteudo = conteudo.replaceAll("k", "c");
        conteudo = conteudo.replaceAll("'", " ");

        conteudo = conteudo.replaceAll("\\?", " ");

        conteudo = conteudo.replaceAll("([áàâãªä])", "a");

//    	        Padroniza letra 'E'
        conteudo = conteudo.replaceAll("([éèêë])", "e");

//    	        Padroniza letra 'I'
        conteudo = conteudo.replaceAll("([íìîï])", "i");

//    	        Padroniza letra 'O'
        conteudo = conteudo.replaceAll("([óòôõº°ö])", "o");

//    	        Padroniza letra 'Ç'
        conteudo = conteudo.replaceAll("([ç])", "c");
        conteudo = conteudo.replaceAll("([ñ])", "n");

        conteudo = conteudo.replaceAll("([²])", "2");
        conteudo = conteudo.replaceAll("([³])", "3");
        conteudo = conteudo.replaceAll("([×])", "x");
        conteudo = conteudo.replaceAll("([æ])", "ae");

        conteudo = conteudo.replaceAll("aa", "a");
        conteudo = conteudo.replaceAll("bb", "b");
        conteudo = conteudo.replaceAll("cc", "c");
        conteudo = conteudo.replaceAll("dd", "d");
        conteudo = conteudo.replaceAll("ee", "e");
        conteudo = conteudo.replaceAll("ff", "f");
        conteudo = conteudo.replaceAll("gg", "g");
        conteudo = conteudo.replaceAll("hh", "h");
        conteudo = conteudo.replaceAll("ii", "i");
        conteudo = conteudo.replaceAll("jj", "j");
        conteudo = conteudo.replaceAll("kk", "k");
        conteudo = conteudo.replaceAll("ll", "l");
        conteudo = conteudo.replaceAll("mm", "m");
        conteudo = conteudo.replaceAll("nn", "n");
        conteudo = conteudo.replaceAll("oo", "o");
        conteudo = conteudo.replaceAll("pp", "p");
        conteudo = conteudo.replaceAll("qq", "q");
        conteudo = conteudo.replaceAll("rr", "r");
        conteudo = conteudo.replaceAll("ss", "s");
        conteudo = conteudo.replaceAll("tt", "t");
        conteudo = conteudo.replaceAll("uu", "u");
        conteudo = conteudo.replaceAll("vv", "v");
        conteudo = conteudo.replaceAll("ww", "w");
        conteudo = conteudo.replaceAll("xx", "x");
        conteudo = conteudo.replaceAll("yy", "y");
        conteudo = conteudo.replaceAll("zz", "z");
        conteudo = conteudo.replaceAll("aa", "a");
        conteudo = conteudo.replaceAll("bb", "b");
        conteudo = conteudo.replaceAll("cc", "c");
        conteudo = conteudo.replaceAll("dd", "d");
        conteudo = conteudo.replaceAll("ee", "e");
        conteudo = conteudo.replaceAll("ff", "f");
        conteudo = conteudo.replaceAll("gg", "g");
        conteudo = conteudo.replaceAll("hh", "h");
        conteudo = conteudo.replaceAll("ii", "i");
        conteudo = conteudo.replaceAll("jj", "j");
        conteudo = conteudo.replaceAll("kk", "k");
        conteudo = conteudo.replaceAll("ll", "l");
        conteudo = conteudo.replaceAll("mm", "m");
        conteudo = conteudo.replaceAll("nn", "n");
        conteudo = conteudo.replaceAll("oo", "o");
        conteudo = conteudo.replaceAll("pp", "p");
        conteudo = conteudo.replaceAll("qq", "q");
        conteudo = conteudo.replaceAll("rr", "r");
        conteudo = conteudo.replaceAll("ss", "s");
        conteudo = conteudo.replaceAll("tt", "t");
        conteudo = conteudo.replaceAll("uu", "u");
        conteudo = conteudo.replaceAll("vv", "v");
        conteudo = conteudo.replaceAll("ww", "w");
        conteudo = conteudo.replaceAll("xx", "x");
        conteudo = conteudo.replaceAll("yy", "y");
        conteudo = conteudo.replaceAll("zz", "z");

        conteudo = conteudo.replaceAll("aa", "a");
        conteudo = conteudo.replaceAll("bb", "b");
        conteudo = conteudo.replaceAll("cc", "c");
        conteudo = conteudo.replaceAll("dd", "d");
        conteudo = conteudo.replaceAll("ee", "e");
        conteudo = conteudo.replaceAll("ff", "f");
        conteudo = conteudo.replaceAll("gg", "g");
        conteudo = conteudo.replaceAll("hh", "h");
        conteudo = conteudo.replaceAll("ii", "i");
        conteudo = conteudo.replaceAll("jj", "j");
        conteudo = conteudo.replaceAll("kk", "k");
        conteudo = conteudo.replaceAll("ll", "l");
        conteudo = conteudo.replaceAll("mm", "m");
        conteudo = conteudo.replaceAll("nn", "n");
        conteudo = conteudo.replaceAll("oo", "o");
        conteudo = conteudo.replaceAll("pp", "p");
        conteudo = conteudo.replaceAll("qq", "q");
        conteudo = conteudo.replaceAll("rr", "r");
        conteudo = conteudo.replaceAll("ss", "s");
        conteudo = conteudo.replaceAll("tt", "t");
        conteudo = conteudo.replaceAll("uu", "u");
        conteudo = conteudo.replaceAll("vv", "v");
        conteudo = conteudo.replaceAll("ww", "w");
        conteudo = conteudo.replaceAll("xx", "x");
        conteudo = conteudo.replaceAll("yy", "y");
        conteudo = conteudo.replaceAll("zz", "z");
        conteudo = conteudo.replaceAll("aa", "a");
        conteudo = conteudo.replaceAll("bb", "b");
        conteudo = conteudo.replaceAll("cc", "c");
        conteudo = conteudo.replaceAll("dd", "d");
        conteudo = conteudo.replaceAll("ee", "e");
        conteudo = conteudo.replaceAll("ff", "f");
        conteudo = conteudo.replaceAll("gg", "g");
        conteudo = conteudo.replaceAll("hh", "h");
        conteudo = conteudo.replaceAll("ii", "i");
        conteudo = conteudo.replaceAll("jj", "j");
        conteudo = conteudo.replaceAll("kk", "k");
        conteudo = conteudo.replaceAll("ll", "l");
        conteudo = conteudo.replaceAll("mm", "m");
        conteudo = conteudo.replaceAll("nn", "n");
        conteudo = conteudo.replaceAll("oo", "o");
        conteudo = conteudo.replaceAll("pp", "p");
        conteudo = conteudo.replaceAll("qq", "q");
        conteudo = conteudo.replaceAll("rr", "r");
        conteudo = conteudo.replaceAll("ss", "s");
        conteudo = conteudo.replaceAll("tt", "t");
        conteudo = conteudo.replaceAll("uu", "u");
        conteudo = conteudo.replaceAll("vv", "v");
        conteudo = conteudo.replaceAll("ww", "w");
        conteudo = conteudo.replaceAll("xx", "x");
        conteudo = conteudo.replaceAll("yy", "y");
        conteudo = conteudo.replaceAll("zz", "z");

        conteudo = conteudo.replaceAll("aa", "a");
        conteudo = conteudo.replaceAll("bb", "b");
        conteudo = conteudo.replaceAll("cc", "c");
        conteudo = conteudo.replaceAll("dd", "d");
        conteudo = conteudo.replaceAll("ee", "e");
        conteudo = conteudo.replaceAll("ff", "f");
        conteudo = conteudo.replaceAll("gg", "g");
        conteudo = conteudo.replaceAll("hh", "h");
        conteudo = conteudo.replaceAll("ii", "i");
        conteudo = conteudo.replaceAll("jj", "j");
        conteudo = conteudo.replaceAll("kk", "k");
        conteudo = conteudo.replaceAll("ll", "l");
        conteudo = conteudo.replaceAll("mm", "m");
        conteudo = conteudo.replaceAll("nn", "n");
        conteudo = conteudo.replaceAll("oo", "o");
        conteudo = conteudo.replaceAll("pp", "p");
        conteudo = conteudo.replaceAll("qq", "q");
        conteudo = conteudo.replaceAll("rr", "r");
        conteudo = conteudo.replaceAll("ss", "s");
        conteudo = conteudo.replaceAll("tt", "t");
        conteudo = conteudo.replaceAll("uu", "u");
        conteudo = conteudo.replaceAll("vv", "v");
        conteudo = conteudo.replaceAll("ww", "w");
        conteudo = conteudo.replaceAll("xx", "x");
        conteudo = conteudo.replaceAll("yy", "y");
        conteudo = conteudo.replaceAll("zz", "z");
        conteudo = conteudo.replaceAll("aa", "a");
        conteudo = conteudo.replaceAll("bb", "b");
        conteudo = conteudo.replaceAll("cc", "c");
        conteudo = conteudo.replaceAll("dd", "d");
        conteudo = conteudo.replaceAll("ee", "e");
        conteudo = conteudo.replaceAll("ff", "f");
        conteudo = conteudo.replaceAll("gg", "g");
        conteudo = conteudo.replaceAll("hh", "h");
        conteudo = conteudo.replaceAll("ii", "i");
        conteudo = conteudo.replaceAll("jj", "j");
        conteudo = conteudo.replaceAll("kk", "k");
        conteudo = conteudo.replaceAll("ll", "l");
        conteudo = conteudo.replaceAll("mm", "m");
        conteudo = conteudo.replaceAll("nn", "n");
        conteudo = conteudo.replaceAll("oo", "o");
        conteudo = conteudo.replaceAll("pp", "p");
        conteudo = conteudo.replaceAll("qq", "q");
        conteudo = conteudo.replaceAll("rr", "r");
        conteudo = conteudo.replaceAll("ss", "s");
        conteudo = conteudo.replaceAll("tt", "t");
        conteudo = conteudo.replaceAll("uu", "u");
        conteudo = conteudo.replaceAll("vv", "v");
        conteudo = conteudo.replaceAll("ww", "w");
        conteudo = conteudo.replaceAll("xx", "x");
        conteudo = conteudo.replaceAll("yy", "y");
        conteudo = conteudo.replaceAll("zz", "z");

        conteudo = conteudo.replaceAll("( a )", " ");
        conteudo = conteudo.replaceAll("( agora )", " ");
        conteudo = conteudo.replaceAll("( ainda )", " ");
        conteudo = conteudo.replaceAll("( alguem )", " ");
        conteudo = conteudo.replaceAll("( algum )", " ");
        conteudo = conteudo.replaceAll("( alguma )", " ");
        conteudo = conteudo.replaceAll("( algumas )", " ");
        conteudo = conteudo.replaceAll("( alguns )", " ");
        conteudo = conteudo.replaceAll("( ampla )", " ");
        conteudo = conteudo.replaceAll("( amplas )", " ");
        conteudo = conteudo.replaceAll("( amplo )", " ");
        conteudo = conteudo.replaceAll("( amplos )", " ");
        conteudo = conteudo.replaceAll("( ante )", " ");
        conteudo = conteudo.replaceAll("( antes )", " ");
        conteudo = conteudo.replaceAll("( ao )", " ");
        conteudo = conteudo.replaceAll("( aos )", " ");
        conteudo = conteudo.replaceAll("( apos )", " ");
        conteudo = conteudo.replaceAll("( aquela )", " ");
        conteudo = conteudo.replaceAll("( aquelas )", " ");
        conteudo = conteudo.replaceAll("( aquele )", " ");
        conteudo = conteudo.replaceAll("( aqueles )", " ");
        conteudo = conteudo.replaceAll("( aquilo )", " ");
        conteudo = conteudo.replaceAll("( as )", " ");
        conteudo = conteudo.replaceAll("( ate )", " ");
        conteudo = conteudo.replaceAll("( atraves )", " ");
        conteudo = conteudo.replaceAll("( cada )", " ");
        conteudo = conteudo.replaceAll("( coisa )", " ");
        conteudo = conteudo.replaceAll("( coisas )", " ");
        conteudo = conteudo.replaceAll("( com )", " ");
        conteudo = conteudo.replaceAll("( como )", " ");
        conteudo = conteudo.replaceAll("( contra )", " ");
        conteudo = conteudo.replaceAll("( contudo )", " ");
        conteudo = conteudo.replaceAll("( da )", " ");
        conteudo = conteudo.replaceAll("( daquele )", " ");
        conteudo = conteudo.replaceAll("( daqueles )", " ");
        conteudo = conteudo.replaceAll("( das )", " ");
        conteudo = conteudo.replaceAll("( de )", " ");
        conteudo = conteudo.replaceAll("( dela )", " ");
        conteudo = conteudo.replaceAll("( delas )", " ");
        conteudo = conteudo.replaceAll("( dele )", " ");
        conteudo = conteudo.replaceAll("( deles )", " ");
        conteudo = conteudo.replaceAll("( dapois )", " ");
        conteudo = conteudo.replaceAll("( daqueles )", " ");
        conteudo = conteudo.replaceAll("( vos )", " ");
        conteudo = conteudo.replaceAll("( depois )", " ");
        conteudo = conteudo.replaceAll("( dessa )", " ");
        conteudo = conteudo.replaceAll("( dessas )", " ");
        conteudo = conteudo.replaceAll("( desse )", " ");
        conteudo = conteudo.replaceAll("( desses )", " ");
        conteudo = conteudo.replaceAll("( desta )", " ");
        conteudo = conteudo.replaceAll("( destas )", " ");
        conteudo = conteudo.replaceAll("( deste )", " ");
        conteudo = conteudo.replaceAll("( destas )", " ");
        conteudo = conteudo.replaceAll("( deste )", " ");
        conteudo = conteudo.replaceAll("( destes )", " ");
        conteudo = conteudo.replaceAll("( deve )", " ");
        conteudo = conteudo.replaceAll("( devem )", " ");
        conteudo = conteudo.replaceAll("( devendo )", " ");
        conteudo = conteudo.replaceAll("( dever )", " ");
        conteudo = conteudo.replaceAll("( devera )", " ");
        conteudo = conteudo.replaceAll("( deverao )", " ");
        conteudo = conteudo.replaceAll("( deveria )", " ");
        conteudo = conteudo.replaceAll("( deveriam )", " ");
        conteudo = conteudo.replaceAll("( devia )", " ");
        conteudo = conteudo.replaceAll("( deviam )", " ");
        conteudo = conteudo.replaceAll("( disse )", " ");
        conteudo = conteudo.replaceAll("( disso )", " ");
        conteudo = conteudo.replaceAll("( disto )", " ");
        conteudo = conteudo.replaceAll("( dito )", " ");
        conteudo = conteudo.replaceAll("( diz )", " ");
        conteudo = conteudo.replaceAll("( dizem )", " ");
        conteudo = conteudo.replaceAll("( do )", " ");
        conteudo = conteudo.replaceAll("( dos )", " ");
        conteudo = conteudo.replaceAll("( e )", " ");
        conteudo = conteudo.replaceAll("( ela )", " ");
        conteudo = conteudo.replaceAll("( elas )", " ");
        conteudo = conteudo.replaceAll("( ele )", " ");
        conteudo = conteudo.replaceAll("( eles )", " ");
        conteudo = conteudo.replaceAll("( em )", " ");
        conteudo = conteudo.replaceAll("( enquanto )", " ");
        conteudo = conteudo.replaceAll("( entre )", " ");
        conteudo = conteudo.replaceAll("( era )", " ");
        conteudo = conteudo.replaceAll("( essa )", " ");
        conteudo = conteudo.replaceAll("( essas )", " ");
        conteudo = conteudo.replaceAll("( esse )", " ");
        conteudo = conteudo.replaceAll("( esses )", " ");
        conteudo = conteudo.replaceAll("( esta )", " ");
        conteudo = conteudo.replaceAll("( estamos )", " ");
        conteudo = conteudo.replaceAll("( estao )", " ");
        conteudo = conteudo.replaceAll("( estas )", " ");
        conteudo = conteudo.replaceAll("( estava )", " ");
        conteudo = conteudo.replaceAll("( estavam )", " ");
        conteudo = conteudo.replaceAll("( estavamos )", " ");
        conteudo = conteudo.replaceAll("( este )", " ");
        conteudo = conteudo.replaceAll("( estes )", " ");
        conteudo = conteudo.replaceAll("( estou )", " ");
        conteudo = conteudo.replaceAll("( eu )", " ");
        conteudo = conteudo.replaceAll("( fazendo )", " ");
        conteudo = conteudo.replaceAll("( fazer )", " ");
        conteudo = conteudo.replaceAll("( feita )", " ");
        conteudo = conteudo.replaceAll("( feitas )", " ");
        conteudo = conteudo.replaceAll("( feito )", " ");
        conteudo = conteudo.replaceAll("( feitos )", " ");
        conteudo = conteudo.replaceAll("( foi )", " ");
        conteudo = conteudo.replaceAll("( for )", " ");
        conteudo = conteudo.replaceAll("( foram )", " ");
        conteudo = conteudo.replaceAll("( fosse )", " ");
        conteudo = conteudo.replaceAll("( fossem )", " ");
        conteudo = conteudo.replaceAll("( grande )", " ");
        conteudo = conteudo.replaceAll("( grandes )", " ");
        conteudo = conteudo.replaceAll("( ha )", " ");
        conteudo = conteudo.replaceAll("( isto )", " ");
        conteudo = conteudo.replaceAll("( ja )", " ");
        conteudo = conteudo.replaceAll("( la )", " ");
        conteudo = conteudo.replaceAll("( lhe )", " ");
        conteudo = conteudo.replaceAll("( lhes )", " ");
        conteudo = conteudo.replaceAll("( lo )", " ");
        conteudo = conteudo.replaceAll("( mas )", " ");
        conteudo = conteudo.replaceAll("( me )", " ");
        conteudo = conteudo.replaceAll("( mesma )", " ");
        conteudo = conteudo.replaceAll("( mesmas )", " ");
        conteudo = conteudo.replaceAll("( mesmo )", " ");
        conteudo = conteudo.replaceAll("( mesmos )", " ");
        conteudo = conteudo.replaceAll("( meu )", " ");
        conteudo = conteudo.replaceAll("( meus )", " ");
        conteudo = conteudo.replaceAll("( minha )", " ");
        conteudo = conteudo.replaceAll("( minhas )", " ");
        conteudo = conteudo.replaceAll("( muita )", " ");
        conteudo = conteudo.replaceAll("( muitas )", " ");
        conteudo = conteudo.replaceAll("( muito )", " ");
        conteudo = conteudo.replaceAll("( muitos )", " ");
        conteudo = conteudo.replaceAll("( na )", " ");
        conteudo = conteudo.replaceAll("( nao )", " ");
        conteudo = conteudo.replaceAll("( nas )", " ");
        conteudo = conteudo.replaceAll("( nem )", " ");
        conteudo = conteudo.replaceAll("( nenhum )", " ");
        conteudo = conteudo.replaceAll("( nessa )", " ");
        conteudo = conteudo.replaceAll("( nessas )", " ");
        conteudo = conteudo.replaceAll("( nesta )", " ");
        conteudo = conteudo.replaceAll("( nestas )", " ");
        conteudo = conteudo.replaceAll("( ninguem )", " ");
        conteudo = conteudo.replaceAll("( nos )", " ");
        conteudo = conteudo.replaceAll("( nossa )", " ");
        conteudo = conteudo.replaceAll("( nossas )", " ");
        conteudo = conteudo.replaceAll("( nosso )", " ");
        conteudo = conteudo.replaceAll("( nossos )", " ");
        conteudo = conteudo.replaceAll("( num )", " ");
        conteudo = conteudo.replaceAll("( numa )", " ");
        conteudo = conteudo.replaceAll("( nunca )", " ");
        conteudo = conteudo.replaceAll("( os )", " ");
        conteudo = conteudo.replaceAll("( ou )", " ");
        conteudo = conteudo.replaceAll("( outra )", " ");
        conteudo = conteudo.replaceAll("( outras )", " ");
        conteudo = conteudo.replaceAll("( outro )", " ");
        conteudo = conteudo.replaceAll("( outros )", " ");
        conteudo = conteudo.replaceAll("( para )", " ");
        conteudo = conteudo.replaceAll("( pela )", " ");
        conteudo = conteudo.replaceAll("( pelas )", " ");
        conteudo = conteudo.replaceAll("( pelo )", " ");
        conteudo = conteudo.replaceAll("( pelos )", " ");
        conteudo = conteudo.replaceAll("( pequena )", " ");
        conteudo = conteudo.replaceAll("( pequenas )", " ");
        conteudo = conteudo.replaceAll("( pequeno )", " ");
        conteudo = conteudo.replaceAll("( pequenos )", " ");
        conteudo = conteudo.replaceAll("( per )", " ");
        conteudo = conteudo.replaceAll("( perante )", " ");
        conteudo = conteudo.replaceAll("( pode )", " ");
        conteudo = conteudo.replaceAll("( pude )", " ");
        conteudo = conteudo.replaceAll("( podendo )", " ");
        conteudo = conteudo.replaceAll("( poder )", " ");
        conteudo = conteudo.replaceAll("( poderia )", " ");
        conteudo = conteudo.replaceAll("( poderiam )", " ");
        conteudo = conteudo.replaceAll("( podia )", " ");
        conteudo = conteudo.replaceAll("( podiam )", " ");
        conteudo = conteudo.replaceAll("( pois )", " ");
        conteudo = conteudo.replaceAll("( por )", " ");
        conteudo = conteudo.replaceAll("( porem )", " ");
        conteudo = conteudo.replaceAll("( porque )", " ");
        conteudo = conteudo.replaceAll("( posso )", " ");
        conteudo = conteudo.replaceAll("( pouca )", " ");
        conteudo = conteudo.replaceAll("( poucas )", " ");
        conteudo = conteudo.replaceAll("( pouco )", " ");
        conteudo = conteudo.replaceAll("( poucos )", " ");
        conteudo = conteudo.replaceAll("( primeiro )", " ");
        conteudo = conteudo.replaceAll("( primeiros )", " ");
        conteudo = conteudo.replaceAll("( propria )", " ");
        conteudo = conteudo.replaceAll("( proprias )", " ");
        conteudo = conteudo.replaceAll("( proprio )", " ");
        conteudo = conteudo.replaceAll("( proprios )", " ");
        conteudo = conteudo.replaceAll("( quais )", " ");
        conteudo = conteudo.replaceAll("( qual )", " ");
        conteudo = conteudo.replaceAll("( quando )", " ");
        conteudo = conteudo.replaceAll("( quanto )", " ");
        conteudo = conteudo.replaceAll("( quantos )", " ");
        conteudo = conteudo.replaceAll("( que )", " ");
        conteudo = conteudo.replaceAll("( quem )", " ");
        conteudo = conteudo.replaceAll("( sao )", " ");
        conteudo = conteudo.replaceAll("( se )", " ");
        conteudo = conteudo.replaceAll("( seja )", " ");
        conteudo = conteudo.replaceAll("( sejam )", " ");
        conteudo = conteudo.replaceAll("( sem )", " ");
        conteudo = conteudo.replaceAll("( sempre )", " ");
        conteudo = conteudo.replaceAll("( sendo )", " ");
        conteudo = conteudo.replaceAll("( sera )", " ");
        conteudo = conteudo.replaceAll("( serao )", " ");
        conteudo = conteudo.replaceAll("( seu )", " ");
        conteudo = conteudo.replaceAll("( seus )", " ");
        conteudo = conteudo.replaceAll("( si )", " ");
        conteudo = conteudo.replaceAll("( sido )", " ");
        conteudo = conteudo.replaceAll("( so )", " ");
        conteudo = conteudo.replaceAll("( sob )", " ");
        conteudo = conteudo.replaceAll("( sobre )", " ");
        conteudo = conteudo.replaceAll("( sua )", " ");
        conteudo = conteudo.replaceAll("( suas )", " ");
        conteudo = conteudo.replaceAll("( talvez )", " ");
        conteudo = conteudo.replaceAll("( tambem )", " ");
        conteudo = conteudo.replaceAll("( tampouco )", " ");
        conteudo = conteudo.replaceAll("( tem )", " ");
        conteudo = conteudo.replaceAll("( tendo )", " ");
        conteudo = conteudo.replaceAll("( tenha )", " ");
        conteudo = conteudo.replaceAll("( ter )", " ");
        conteudo = conteudo.replaceAll("( teu )", " ");
        conteudo = conteudo.replaceAll("( teus )", " ");
        conteudo = conteudo.replaceAll("( ti )", " ");
        conteudo = conteudo.replaceAll("( tido )", " ");
        conteudo = conteudo.replaceAll("( tinha )", " ");
        conteudo = conteudo.replaceAll("( tinham )", " ");
        conteudo = conteudo.replaceAll("( toda )", " ");
        conteudo = conteudo.replaceAll("( todas )", " ");
        conteudo = conteudo.replaceAll("( todavia )", " ");
        conteudo = conteudo.replaceAll("( todo )", " ");
        conteudo = conteudo.replaceAll("( todos )", " ");
        conteudo = conteudo.replaceAll("( tu )", " ");
        conteudo = conteudo.replaceAll("( tua )", " ");
        conteudo = conteudo.replaceAll("( tuas )", " ");
        conteudo = conteudo.replaceAll("( tudo )", " ");
        conteudo = conteudo.replaceAll("( ultima )", " ");
        conteudo = conteudo.replaceAll("( ultimas )", " ");
        conteudo = conteudo.replaceAll("( ultimo )", " ");
        conteudo = conteudo.replaceAll("( ultimos )", " ");
        conteudo = conteudo.replaceAll("( um )", " ");
        conteudo = conteudo.replaceAll("( uma )", " ");
        conteudo = conteudo.replaceAll("( umas )", " ");
        conteudo = conteudo.replaceAll("( uns )", " ");
        conteudo = conteudo.replaceAll("( vendo )", " ");
        conteudo = conteudo.replaceAll("( ver )", " ");
        conteudo = conteudo.replaceAll("( vez )", " ");
        conteudo = conteudo.replaceAll("( vindo )", " ");
        conteudo = conteudo.replaceAll("( vir )", " ");
        conteudo = conteudo.replaceAll("( vos )", " ");
//
////        conteudo = BrazilianStemmer.stem(conteudo);
        conteudo = conteudo.trim();
        return conteudo;
    }


}
