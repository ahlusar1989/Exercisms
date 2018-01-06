package matrix

import (
	"fmt"
	"strconv"
	"strings"
)

type Matrix struct {
	rows int
	cols int
	data []int
}

func New(inputString string) (*Matrix, error) {
	parsedRows := strings.Split(inputString, "\n")
	newm := Matrix{rows: len(parsedRows), cols: -1}
	for _, row := range parsedRows {
		parsedColumns := strings.Split(strings.TrimSpace(row), " ")
		if newm.cols == -1 {
			newm.cols = len(parsedColumns)
		} else if newm.cols != len(parsedColumns) {
			return nil, fmt.Errorf("Rows are not the same length")
		}
		for _, char := range parsedColumns {
			num, err := strconv.Atoi(char)
			if err != nil {
				return nil, err
			}
			newm.data = append(newm.data, num)
		}
	}
	return &newm, nil
}

func (m Matrix) Rows() [][]int {
	rows := make([][]int, m.rows)
	for r := 0; r < m.rows; r++ {
		rows[r] = make([]int, m.cols)
		for c := 0; c < m.cols; c++ {
			rows[r][c] = m.data[r*m.cols+c]
		}
	}
	return rows
}

func (m Matrix) Cols() [][]int {
	cols := make([][]int, m.cols)
	for c := 0; c < m.cols; c++ {
		cols[c] = make([]int, m.rows)
		for r := 0; r < m.rows; r++ {
			cols[c][r] = m.data[r*m.cols+c]
		}
	}
	return cols
}

func (m *Matrix) Set(row, col, value int) bool {
	if row < 0 || m.rows <= row || col < 0 || m.cols <= col {
		return false
	}
	m.data[row*m.cols+col] = value
	return true
}
