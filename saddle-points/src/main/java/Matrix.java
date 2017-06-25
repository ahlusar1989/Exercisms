import java.util.*;

class Matrix {
    private final List<List<Integer>> values;

    public Matrix (final List<List<Integer>> values){
        this.values = values;
    }

    public Set<MatrixCoordinate> getSaddlePoints(){
        final Set<MatrixCoordinate> saddlePoints = new HashSet<>();

        if(values.isEmpty()){
            return saddlePoints;
        }
        for(int row = 0; row < values.size(); row++){
          for(int column = 0; column < values.get(row).size(); column ++){
              final int currentCoordinateValue = values.get(row).get(column);

              if( (getRowMax(row) == currentCoordinateValue) &&
                      (getColumnMiniumum(column) == currentCoordinateValue) ){
                  saddlePoints.add(new MatrixCoordinate(row, column));
              }
          }
        }
        return saddlePoints;
    }

    private int getRowMax(final int row){
       return Collections.max(values.get(row));
    }

    private int getColumnMiniumum(final int column){
        return values.stream()
                .map(row -> row.get(column))
                .min(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Column cannot be empty!"));
    }

}
