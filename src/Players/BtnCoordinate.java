package Players;

public class BtnCoordinate {
    int[][] coord = new int[1][2];
    BtnCoordinate()
    {
    }

    public int[][] getButtonCoordinate(int i) {
        int[][] coord = new int[1][2]; // x, y
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
                break;
        }
        return coord;

    }
}
