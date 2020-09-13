public class BtnCoordinate {
    int[][] coord = new int[1][2];
    BtnCoordinate()
    {
    }

    public int[][] getButtonCoordinate(int i) {
//        final int a = 0, b = 1;
//        int[][] btnLoc = new int[1][9];
        int[][] coord = new int[1][2]; // x, y
//        (i==0)? (coord[0][0]=0; coord[0][1]==0)


        switch (i) {
            case 0:
                coord[0][0] = 0;
                coord[0][1] = 0;
                break;

            case 1:
                coord[0][0] = 0;
                coord[0][1] = 1;
                break;

            case 2:
                coord[0][0] = 0;
                coord[0][1] = 2;
                break;

            case 3:
                coord[0][0] = 1;
                coord[0][1] = 0;
                break;

            case 4:
                coord[0][0] = 1;
                coord[0][1] = 1;
                break;

            case 5:
                coord[0][0] = 1;
                coord[0][1] = 2;
                break;

            case 6:
                coord[0][0] = 2;
                coord[0][1] = 0;
                break;

            case 7:
                coord[0][0] = 2;
                coord[0][1] = 1;
                break;

            case 8:
                coord[0][0] = 2;
                coord[0][1] = 2;
                break;

            default:
                //System.out.println("Error");
                break;
        }
        return coord;

    }
}
