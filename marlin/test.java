import java.util.ArrayList;

class test {
    Nut matchedNut = null;

    public static void main(String args[]){
        ArrayList<Bolt> bolts = new ArrayList<>();
        bolts.add(new Bolt(3));
        bolts.add(new Bolt(1));
        bolts.add(new Bolt(2));
        bolts.add(new Bolt(4));
        bolts.add(new Bolt(5));
        bolts.add(new Bolt(7));
        bolts.add(new Bolt(10));
        bolts.add(new Bolt(9));
        bolts.add(new Bolt(8));
        bolts.add(new Bolt(6));

        ArrayList<Nut> nuts = new ArrayList<>();
        nuts.add(new Nut(1));
        nuts.add(new Nut(2));
        nuts.add(new Nut(3));
        nuts.add(new Nut(4));
        nuts.add(new Nut(5));
        nuts.add(new Nut(6));
        nuts.add(new Nut(7));
        nuts.add(new Nut(8));
        nuts.add(new Nut(9));
        nuts.add(new Nut(10));

        new test().soWork(bolts, nuts);
    }

    void soWork(ArrayList<Bolt> bolts, ArrayList<Nut> nuts){
        if(bolts.isEmpty() || nuts.isEmpty()) {
            return;
        }
        Bolt b1 = bolts.get(0);
        ArrayList<Nut> smallerList = new ArrayList<>();
        ArrayList<Nut> biggerList = new ArrayList<>();
        nuts.forEach(nut -> {
            int comparison = isMatch(b1,nut);
			// System.out.println(comparison);
            if( comparison == 0){
                matchedNut = nut;
                System.out.println(b1 + " " + nut);
            } else if(comparison > 0) {
                smallerList.add(nut);
				// System.out.println("small: " + smallerList);
            } else {
                biggerList.add(nut);
				// System.out.println("big: " + biggerList);
            }
        });

        ArrayList<Bolt> smallerBoltList = new ArrayList<>();
        ArrayList<Bolt> biggerBoltList = new ArrayList<>();

		bolts.remove(b1);
		nuts.remove(matchedNut);

        bolts.forEach(bolt -> {
            int comparison = isMatch(bolt,matchedNut);
            if(comparison > 0) {
                biggerBoltList.add(bolt);
            } else {
                smallerBoltList.add(bolt);
            }
        });

		matchedNut = null;
        soWork(smallerBoltList, smallerList);
        soWork(biggerBoltList, biggerList);
    }

    int isMatch(Bolt b, Nut n){
        if(b.id < n.id) {
            return -1; // bolt is smaller
        } else if(b.id > n.id) {
            return 1;  // bolt is bigger
        }
        else{
            return 0;
        }
    }
}


class Bolt{
    int id;

    Bolt(int id){
        this.id = id;
    }

    @Override
    public String toString(){
        return "Bolt: " + id;
    }
}

class Nut{
    int id;

    Nut(int id){
        this.id = id;
    }

    @Override
    public String toString(){
        return "Nut: " + id;
    }
}