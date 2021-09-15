val invalidMessage: String = "Invalid response."

val esc: String = Character.toString(27.toChar())
val startBlue: String = "$esc[30;44m"
val startGrey: String = "$esc[30;47m"
val startWhite: String = "$esc[30;30m"
val end: String = "$esc[0m"

val blankWhite: String = "$startGrey   $end"
val blankBlack: String = "$startWhite   $end"
val blankBlue: String = "$startBlue   $end"

//Pairs pieces
val blackPawnPair : Pair <String,String> = Pair("P","b")
val blackHorsePair : Pair <String,String> = Pair("H","b")
val blackKingPair : Pair <String,String> = Pair("K","b")
val blackTowerPair : Pair <String,String> = Pair("T","b")
val blackBishopPair : Pair <String,String> = Pair("B","b")
val blackQueenPair : Pair <String,String> = Pair("Q","b")

val whitePawnPair : Pair <String,String> = Pair("P","w")
val whiteHorsePair : Pair <String,String> = Pair("H","w")
val whiteKingPair : Pair <String,String> = Pair("K","w")
val whiteTowerPair : Pair <String,String> = Pair("T","w")
val whiteBishopPair : Pair <String,String> = Pair("B","w")
val whiteQueenPair : Pair <String,String> = Pair("Q","w")

//Pieces
val blackKing: String = "\u265A"
val blackQueen: String = "\u265B"
val blackTower: String = "\u265C"
val blackBishop: String = "\u265D"
val blackHorse: String = "\u265E"
val blackPawn: String = "\u265F"

val whiteKing: String = "\u2654"
val whiteQueen: String = "\u2655"
val whiteTower: String = "\u2656"
val whiteBishop: String = "\u2657"
val whiteHorse: String = "\u2658"
val whitePawn: String = "\u2659"

//BoardLabels
val blueA: String = "$startBlue A $end"
val blueB: String = "$startBlue B $end"
val blueC: String = "$startBlue C $end"
val blueD: String = "$startBlue D $end"
val blueE: String = "$startBlue E $end"
val blueF: String = "$startBlue F $end"
val blueG: String = "$startBlue G $end"
val blueH: String = "$startBlue H $end"

fun getBlueLegend(label: String): String{
    return "$startBlue $label $end"
}

fun getBoardLegendTop(columns: Int): String{
    if(columns == 4){
        return blankBlue + blueA + blueB + blueC + blueD + blankBlue + '\n'
    }
    if(columns == 6){
        return blankBlue + blueA + blueB + blueC + blueD + blueE + blueF + blankBlue + '\n'
    }
    if(columns == 7){
        return blankBlue + blueA + blueB + blueC + blueD + blueE + blueF + blueG + blankBlue + '\n'
    }
    if(columns == 8){
        return blankBlue + blueA + blueB + blueC + blueD + blueE + blueF + blueG + blueH+ blankBlue + '\n'
    }
    return ""
}

fun getBoardLegendBottom(columns: Int): String{
    if(columns == 4){
        return blankBlue + blankBlue + blankBlue + blankBlue + blankBlue + blankBlue + '\n'
    }
    if(columns == 6){
        return blankBlue + blankBlue + blankBlue + blankBlue + blankBlue + blankBlue + blankBlue + blankBlue + '\n'
    }
    if(columns == 7){
        return blankBlue + blankBlue + blankBlue + blankBlue + blankBlue +
                blankBlue + blankBlue + blankBlue + blankBlue + '\n'
    }
    if(columns == 8){
        return blankBlue + blankBlue + blankBlue + blankBlue + blankBlue +
                blankBlue + blankBlue + blankBlue + blankBlue + blankBlue + '\n'
    }
    return ""
}

fun boardLegendAndPieces(numLines: Int, numColumns: Int, pieces: Array<Pair<String,String>?>): String{
    if(numLines == 7 && numColumns == 7){
        return boardLegendAndPieces7x7(numLines,numColumns,pieces)
    }
    var board = getBoardLegendTop(numColumns)
    var counter = 1
    var counter2 = 1
    var piecesPos = 0
    while(counter <= numLines){
        board += getBlueLegend(counter.toString())
        while(counter2 <= numColumns){
            if(counter % 2 != 0){
                if(piecesPos % 2 == 0) {
                    board += makeBlackSpot(
                        convertStringToUnicode(
                            pieces[piecesPos]?.first.toString(),pieces[piecesPos]?.second.toString())
                    )
                } else {
                    board += makeWhiteSpot(
                        convertStringToUnicode(
                            pieces[piecesPos]?.first.toString(),pieces[piecesPos]?.second.toString()
                        )
                    )
                }
            }
            else{
                if(piecesPos % 2 != 0) {
                    board += makeBlackSpot(
                        convertStringToUnicode(
                            pieces[piecesPos]?.first.toString(),pieces[piecesPos]?.second.toString())
                    )
                }else{
                    board += makeWhiteSpot(
                        convertStringToUnicode(
                            pieces[piecesPos]?.first.toString(),pieces[piecesPos]?.second.toString()
                        )
                    )
                }
            }
            counter2++
            piecesPos++
        }
        counter2 = 1
        counter++
        board += blankBlue + '\n'
    }
    board += getBoardLegendBottom(numColumns)
    return board
}

fun boardLegendAndPieces7x7(numLines: Int, numColumns: Int, pieces: Array<Pair<String,String>?>): String{
    var board = getBoardLegendTop(numColumns)
    var counter = 1
    var counter2 = 1
    var piecesPos = 0
    while(counter <= numLines){
        board += getBlueLegend(counter.toString())
        while(counter2 <= numColumns){
            if(counter % 2 != 0){
                if(piecesPos % 2 == 0) {
                    board += makeBlackSpot(convertStringToUnicode(
                        pieces[piecesPos]?.first.toString(),pieces[piecesPos]?.second.toString())
                    )
                } else {
                    board += makeWhiteSpot(convertStringToUnicode(
                        pieces[piecesPos]?.first.toString(),pieces[piecesPos]?.second.toString()
                    )
                    )
                }
            }
            else{
                if(piecesPos % 2 == 0) {
                    board += makeBlackSpot(convertStringToUnicode(
                        pieces[piecesPos]?.first.toString(),pieces[piecesPos]?.second.toString())
                    )
                }else{
                    board += makeWhiteSpot(convertStringToUnicode(
                        pieces[piecesPos]?.first.toString(),pieces[piecesPos]?.second.toString()
                    )
                    )
                }
            }
            counter2++
            piecesPos++
        }
        counter2 = 1
        counter++
        board += blankBlue + '\n'
    }
    board += getBoardLegendBottom(numColumns)
    return board
}

fun boardJustLegends(numLines: Int, numColumns: Int, pieces: Array<Pair<String,String>?>): String{
    if(numLines == 7 && numColumns == 7){
        return boardJustLegends7x7(numLines,numColumns,pieces)
    }
    var board = getBoardLegendTop(numColumns)
    var counter = 1
    var counter2 = 1
    var piecesPos = 0
    while(counter <= numLines){
        board += getBlueLegend(counter.toString())
        while(counter2 <= numColumns){
            if(counter % 2 != 0){
                if(piecesPos % 2 == 0) {
                    board += blankBlack
                } else {
                    board += blankWhite
                }
            }
            else{
                if(piecesPos % 2 != 0) {
                    board += blankBlack
                }else{
                    board += blankWhite
                }
            }
            counter2++
            piecesPos++
        }
        counter2 = 1
        counter++
        board += blankBlue + '\n'
    }
    board += getBoardLegendBottom(numColumns)
    return board
}

fun boardJustLegends7x7(numLines: Int, numColumns: Int, pieces: Array<Pair<String,String>?>): String{
    var board = getBoardLegendTop(numColumns)
    var counter = 1
    var counter2 = 1
    var piecesPos = 0
    while(counter <= numLines){
        board += getBlueLegend(counter.toString())
        while(counter2 <= numColumns){
            if(counter % 2 != 0){
                if(piecesPos % 2 == 0) {
                    board += blankBlack
                } else {
                    board += blankWhite
                }
            }
            else{
                if(piecesPos % 2 == 0) {
                    board += blankBlack
                }else{
                    board += blankWhite
                }
            }
            counter2++
            piecesPos++
        }
        counter2 = 1
        counter++
        board += blankBlue + '\n'
    }
    board += getBoardLegendBottom(numColumns)
    return board
}

fun boardJustPieces(numLines: Int, numColumns: Int, pieces: Array<Pair<String,String>?>): String{
    if(numLines == 7 && numColumns == 7){
        return boardJustPieces7x7(numLines,numColumns,pieces)
    }
    var board = ""
    var piecesPos = 0
    var counter = 1
    var counter2 = 1
    while(counter <= numLines){
        while(counter2 <= numColumns){
            if(counter % 2 != 0){
                if(piecesPos % 2 == 0) {
                    board += makeBlackSpot(
                        convertStringToUnicode(
                            pieces[piecesPos]?.first.toString(),pieces[piecesPos]?.second.toString())
                    )
                } else {
                    board += makeWhiteSpot(
                        convertStringToUnicode(
                            pieces[piecesPos]?.first.toString(),pieces[piecesPos]?.second.toString()
                        )
                    )
                }
            }
            else{
                if(piecesPos % 2 != 0) {
                    board += makeBlackSpot(
                        convertStringToUnicode(
                            pieces[piecesPos]?.first.toString(),pieces[piecesPos]?.second.toString())
                    )
                }else{
                    board += makeWhiteSpot(
                        convertStringToUnicode(
                            pieces[piecesPos]?.first.toString(),pieces[piecesPos]?.second.toString()
                        )
                    )
                }
            }
            counter2++
            piecesPos++
        }
        board += '\n'
        counter++
        counter2=1
    }
    return board
}

fun boardJustPieces7x7(numLines: Int, numColumns: Int, pieces: Array<Pair<String,String>?>): String{
    var board = ""
    var counter = 1
    var counter2 = 1
    var piecesPos = 0
    while(counter <= numLines){
        while(counter2 <= numColumns){
            if(counter % 2 != 0){
                if(piecesPos % 2 == 0) {
                    board += makeBlackSpot(convertStringToUnicode(
                        pieces[piecesPos]?.first.toString(),pieces[piecesPos]?.second.toString())
                    )
                } else {
                    board += makeWhiteSpot(convertStringToUnicode(
                        pieces[piecesPos]?.first.toString(),pieces[piecesPos]?.second.toString()
                    )
                    )
                }
            }
            else{
                if(piecesPos % 2 == 0) {
                    board += makeBlackSpot(convertStringToUnicode(
                        pieces[piecesPos]?.first.toString(),pieces[piecesPos]?.second.toString())
                    )
                }else{
                    board += makeWhiteSpot(convertStringToUnicode(
                        pieces[piecesPos]?.first.toString(),pieces[piecesPos]?.second.toString()
                    )
                    )
                }
            }
            counter2++
            piecesPos++
        }
        counter2 = 1
        counter++
        board += '\n'
    }
    return board
}

fun boardBlank(numLines: Int, numColumns: Int, pieces: Array<Pair<String,String>?>): String{
    if(numLines == 7 && numColumns == 7){
        return boardBlank7x7(numLines,numColumns,pieces)
    }
    var board = ""
    var piecesPos = 0
    var counter = 1
    var counter2 = 1
    while(counter <= numLines){
        while(counter2 <= numColumns){
            if(counter % 2 != 0){
                if(piecesPos % 2 == 0) {
                    board += blankBlack
                } else {
                    board += blankWhite
                }
            }
            else{
                if(piecesPos % 2 != 0) {
                    board += blankBlack
                }else{
                    board += blankWhite
                }
            }
            counter2++
            piecesPos++
        }
        board += '\n'
        counter++
        counter2=1
    }
    return board
}

fun boardBlank7x7(numLines: Int, numColumns: Int, pieces: Array<Pair<String,String>?>): String{
    var board = ""
    var counter = 1
    var counter2 = 1
    var piecesPos = 0
    while(counter <= numLines){
        while(counter2 <= numColumns){
            if(counter % 2 != 0){
                if(piecesPos % 2 == 0) {
                    board += blankBlack
                } else {
                    board += blankWhite
                }
            }
            else{
                if(piecesPos % 2 == 0) {
                    board += blankBlack
                }else{
                    board += blankWhite
                }
            }
            counter2++
            piecesPos++
        }
        counter2 = 1
        counter++
        board += '\n'
    }
    return board
}

fun makeBlackSpot(piece: String): String {
    return "$startWhite $piece $end"
}

fun makeWhiteSpot(piece: String): String{
    return "$startGrey $piece $end"
}

fun countBlankSpace(word: String): Int{
    var pos: Int = 0
    var count: Int = 0

    while(pos < word.length){
        if(word[pos] == ' '){
            count++
        }
        pos++
    }
    return count
}

fun showChessLegendOrPieces(message: String): Boolean? {
    if(message.equals("Y") || message.equals("y")){
        return true
    }
    else if(message.equals("N") || message.equals("n")){
        return false
    }
    return null
}

fun checkName(number: String):Boolean{
    var pos: Int = 0

    if(countBlankSpace(number) != 1 || number[0].toInt() < 65 || number[0].toInt() > 90){
        return false
    }
    while(pos < number.length){
        if(number[pos] == ' '){
            pos++
            if(number[pos].toInt() < 65 || number[pos].toInt() > 90){
                return false
            }
        }
        pos++
    }
    return true
}

fun checkIsNumber(number: String): Boolean {
    var pos: Int = 0

    if(number.equals("")){
        return false
    }
    while(pos < number.length){
        if(number[pos].toInt() < 47 || number[pos].toInt() > 57){
            return false
        }
        pos++
    }
    return true
}

fun buildMenu(): String {
    return "1-> Start New Game;\n2-> Exit Game.\n"
}

fun getFirstName(): String {
    var firstName: String = ""

    do{
        print("First player name?\n\n")
        firstName = readLine()!!
        if(!checkName(firstName)){
            println(invalidMessage)
        }
    }while(!checkName(firstName))
    return firstName
}

fun getSecondName(): String {
    var secondName: String = ""
    do{
        print("Second player name?\n\n")
        secondName = readLine()!!
        if(!checkName(secondName)){
            println(invalidMessage)
        }
    }while(!checkName(secondName))
    return secondName
}

fun getColumnsNumber(): Int {
    var input: String = ""
    var columns: Int = 0
    do{
        print("How many chess columns?\n\n")
        input = readLine()!!
        if(checkIsNumber(input)){
            columns = input.toInt()
        }
        else{
            println(invalidMessage)
        }
    }while(!checkIsNumber(input))
    return columns
}

fun getLinesNumber(): Int {
    var lines: Int = 0
    var input: String = ""
    do{
        print("How many chess lines?\n\n")
        input = readLine()!!
        if(checkIsNumber(input)){
            lines = input.toInt()
        }
        else{
            println(invalidMessage)
        }
    }while(!checkIsNumber(input))
    return lines
}

fun showLegend(): Boolean {
    var showLegends: Boolean = false
    var input: String = ""
    do{
        print("Show legend (y/n)?\n\n")
        input = readLine()!!
        if(showChessLegendOrPieces(input) != null){
            if(showChessLegendOrPieces(input) == true){
                showLegends = true
            }
        }
        else{
            println(invalidMessage)
        }
    }while(showChessLegendOrPieces(input) == null)
    return showLegends
}

fun showPieces(): Boolean {
    var showPieces: Boolean = false
    var input: String = ""
    do{
        print("Show pieces (y/n)?\n\n")
        input = readLine()!!
        if(showChessLegendOrPieces(input) != null){
            if(showChessLegendOrPieces(input) == true){
                showPieces = true
            }
        }
        else{
            println(invalidMessage)
        }
    }while(showChessLegendOrPieces(input) == null)
    return showPieces
}

fun buildBoard(numColumns: Int, numLines: Int, showLegend: Boolean = false,
               showPieces: Boolean = false, pieces: Array<Pair<String,String>?>): String{

    if(showLegend && showPieces){
        return boardLegendAndPieces(numLines, numColumns, pieces)
    }
    if(!showLegend && showPieces){
        return boardJustPieces(numLines, numColumns, pieces)
    }
    if(showLegend && !showPieces){
        return boardJustLegends(numLines, numColumns, pieces)
    }
    return boardBlank(numLines, numColumns, pieces)

}

fun createInitialBoard(numColumns: Int, numLines: Int): Array<Pair<String,String>?>{
    if(numColumns == 8 && numLines == 8){
        return createInitialBoard8x8(numColumns, numLines)
    }
    if(numColumns == 7 && numLines == 7){
        return createInitialBoard7x7(numColumns, numLines)
    }
    if(numColumns == 6 && numLines == 6){
        return createInitialBoard6x6(numColumns, numLines)
    }
    if(numColumns == 6 && numLines == 7){
        return createInitialBoard6x7(numColumns, numLines)
    }
    if(numColumns == 4 && numLines == 4){
        return createInitialBoard4x4(numColumns, numLines)
    }
    val pecas : Array<Pair<String,String>?> = emptyArray()
    return pecas
}

fun createInitialBoard4x4(numColumns: Int, numLines: Int): Array<Pair<String,String>?>{
    var pos = 0
    val pecas : Array<Pair<String,String>?> = arrayOfNulls(numColumns*numLines)
    while (pos < numColumns*numLines){
        if(pos == 2){ pecas[pos] = blackTowerPair
        }
        else if(pos == 3){ pecas[pos] = blackBishopPair
        }
        else if(pos == 12){ pecas[pos] = whiteTowerPair
        }
        else if(pos == 13){ pecas[pos] = whiteQueenPair
        }
        pos++
    }
    return pecas
}

fun createInitialBoard6x6(numColumns: Int, numLines: Int): Array<Pair<String,String>?>{
    var pos = 0
    val pecas : Array<Pair<String,String>?> = arrayOfNulls(numColumns*numLines)
    while (pos < numColumns*numLines){
        if(pos == 0){
            pecas[pos] = blackHorsePair
        }
        else if(pos == 1){ pecas[pos] = blackBishopPair
        }
        else if(pos == 2){ pecas[pos] = blackQueenPair
        }
        else if(pos == 3){ pecas[pos] = blackKingPair
        }
        else if(pos == 4){ pecas[pos] = blackBishopPair
        }
        else if(pos == 5){ pecas[pos] = blackTowerPair
        }

        else if(pos in 6 .. 11){ pecas[pos] = blackPawnPair
        }
        else if(pos in 24 .. 29){ pecas[pos] = whitePawnPair
        }

        else if(pos == 30){ pecas[pos] = whiteHorsePair
        }
        else if(pos == 31){ pecas[pos] = whiteBishopPair
        }
        else if(pos == 32){ pecas[pos] = whiteKingPair
        }
        else if(pos == 33){ pecas[pos] = whiteQueenPair
        }
        else if(pos == 34){ pecas[pos] = whiteBishopPair
        }
        else if(pos == 35){ pecas[pos] = whiteTowerPair
        }
        pos++
    }
    return pecas
}

fun createInitialBoard6x7(numColumns: Int, numLines: Int): Array<Pair<String,String>?>{
    var pos = 0
    val pecas : Array<Pair<String,String>?> = arrayOfNulls(numColumns*numLines)
    while (pos < numColumns*numLines){
        if(pos == 0){ pecas[pos] = blackTowerPair
        }
        else if(pos == 1){ pecas[pos] = blackBishopPair
        }
        else if(pos == 2){ pecas[pos] = blackQueenPair
        }
        else if(pos == 3){ pecas[pos] = blackKingPair
        }
        else if(pos == 4){ pecas[pos] = blackBishopPair
        }
        else if(pos == 5){ pecas[pos] = blackHorsePair
        }

        else if(pos == 6 || pos == 7 ||pos == 8 ||pos == 9 ||pos == 10 ||pos == 11){ pecas[pos] = blackPawnPair
        }
        else if(pos == 30 || pos == 31 ||pos == 32 ||pos == 33 ||pos == 34 ||pos == 35){ pecas[pos] = whitePawnPair
        }

        else if(pos == 36){ pecas[pos] = whiteTowerPair
        }
        else if(pos == 37){ pecas[pos] = whiteBishopPair
        }
        else if(pos == 38){ pecas[pos] = whiteKingPair
        }
        else if(pos == 39){ pecas[pos] = whiteQueenPair
        }
        else if(pos == 40){ pecas[pos] = whiteBishopPair
        }
        else if(pos == 41){ pecas[pos] = whiteHorsePair
        }
        pos++
    }
    return pecas

}

fun createInitialBoard7x7(numColumns: Int, numLines: Int): Array<Pair<String,String>?>{
    var pos = 0
    val pecas : Array<Pair<String,String>?> = arrayOfNulls(numColumns*numLines)
    while (pos < numColumns*numLines){
        if(pos == 0 || pos == 6){ pecas[pos] = blackTowerPair
        }
        else if(pos == 1 || pos == 5){ pecas[pos] = blackHorsePair
        }
        else if(pos == 2 || pos == 4){ pecas[pos] = blackBishopPair
        }
        else if(pos == 3){ pecas[pos] = blackKingPair
        }

        else if(pos in 7..13){ pecas[pos] = blackPawnPair
        }
        else if(pos in 35..41){ pecas[pos] = whitePawnPair
        }

        else if(pos == 42 || pos == 48){ pecas[pos] = whiteTowerPair
        }
        else if(pos == 43 || pos == 47){ pecas[pos] = whiteHorsePair
        }
        else if(pos == 44 || pos == 46){ pecas[pos] = whiteBishopPair
        }
        else if(pos == 45){ pecas[pos] = whiteKingPair
        }
        pos++
    }
    return pecas
}

fun createInitialBoard8x8(numColumns: Int, numLines: Int): Array<Pair<String,String>?>{
    var pos = 0
    val pecas : Array<Pair<String,String>?> = arrayOfNulls(numColumns*numLines)
    while (pos < numColumns*numLines){

        if(pos == 0 || pos == 7){ pecas[pos] = blackTowerPair
        }
        else if(pos == 1 || pos == 6){ pecas[pos] = blackHorsePair
        }
        else if(pos == 2 || pos == 5){ pecas[pos] = blackBishopPair
        }
        else if(pos == 3){ pecas[pos] = blackQueenPair
        }
        else if(pos == 4){ pecas[pos] = blackKingPair
        }

        else if(pos in 8..15){ pecas[pos] = blackPawnPair
        }
        else if(pos in 48..55){ pecas[pos] = whitePawnPair
        }

        else if(pos == 56 || pos == 63){ pecas[pos] = whiteTowerPair
        }
        else if(pos == 57 || pos == 62){ pecas[pos] = whiteHorsePair
        }
        else if(pos == 58 || pos == 61){ pecas[pos] = whiteBishopPair
        }
        else if(pos == 59){ pecas[pos] = whiteKingPair
        }
        else if(pos == 60){ pecas[pos] = whiteQueenPair
        }
        pos++
    }
    return pecas
}

fun createTotalPiecesAndTurn(numColumns: Int, numLines: Int): Array<Int?>{
    var total : Array<Int?> = arrayOfNulls(3)
    if(numColumns == 4 && numLines == 4){
        total[0] = 2
        total[1] = 2
        total[2] = 0
    }
    else if(numColumns == 6 && numLines == 6){
        total[0] = 12
        total[1] = 12
        total[2] = 0
    }
    else if(numColumns == 6 && numLines == 7){
        total[0] = 12
        total[1] = 12
        total[2] = 0
    }
    else if(numColumns == 7 && numLines == 7){
        total[0] = 14
        total[1] = 14
        total[2] = 0
    }
    else if(numColumns == 8 && numLines == 8){
        total[0] = 16
        total[1] = 16
        total[2] = 0
    }
    else{
        total = emptyArray()
    }
    return total
}

fun convertStringToUnicode(piece:String, color: String): String{
    if(piece.equals(blackTowerPair.first) && color.equals(blackTowerPair.second)){
        return blackTower
    }
    if(piece.equals(whiteTowerPair.first) && color.equals(whiteTowerPair.second)){
        return whiteTower
    }
    if(piece.equals(blackHorsePair.first) && color.equals(blackHorsePair.second)){
        return blackHorse
    }
    if(piece.equals(whiteHorsePair.first) && color.equals(whiteHorsePair.second)){
        return whiteHorse
    }
    if(piece.equals(blackBishopPair.first) && color.equals(blackBishopPair.second)){
        return blackBishop
    }
    if(piece.equals(whiteBishopPair.first) && color.equals(whiteBishopPair.second)){
        return whiteBishop
    }
    if(piece.equals(blackQueenPair.first) && color.equals(blackQueenPair.second)){
        return blackQueen
    }
    if(piece.equals(whiteQueenPair.first) && color.equals(whiteQueenPair.second)){
        return whiteQueen
    }
    if(piece.equals(blackKingPair.first) && color.equals(blackKingPair.second)){
        return blackKing
    }
    if(piece.equals(whiteKingPair.first) && color.equals(whiteKingPair.second)){
        return whiteKing
    }
    if(piece.equals(blackPawnPair.first) && color.equals(blackPawnPair.second)){
        return blackPawn
    }
    if(piece.equals(whitePawnPair.first) && color.equals(whitePawnPair.second)){
        return whitePawn
    }
    return " "
}

fun getCoordinates (readText: String?): Pair<Int, Int>?{
    var first = 0
    var second = 0
    if (readText != null) {
        if(readText.length != 2 || !checkIsNumber(readText[0].toString())){
            return null
        }
        first = readText[0].toInt()-48
        if(readText[1] == 'A' || readText[1] == 'a'){
            second = 1
            return Pair(first,second)
        }
        if(readText[1] == 'B' || readText[1] == 'b'){
            second = 2
            return Pair(first,second)
        }
        if(readText[1] == 'C' || readText[1] == 'c'){
            second = 3
            return Pair(first,second)
        }
        if(readText[1] == 'D' || readText[1] == 'd'){
            second = 4
            return Pair(first,second)
        }
        if(readText[1] == 'E' || readText[1] == 'e'){
            second = 5
            return Pair(first,second)
        }
        if(readText[1] == 'F' || readText[1] == 'f'){
            second = 6
            return Pair(first,second)
        }
        if(readText[1] == 'G' || readText[1] == 'g'){
            second = 7
            return Pair(first,second)
        }
        if(readText[1] == 'H' || readText[1] == 'h'){
            second = 8
            return Pair(first,second)
        }
    }
    return null
}

fun checkRightPieceSelected(pieceColor:String, turn: Int): Boolean{
    if(turn == 0 && pieceColor.equals("w")){
        return true
    }
    if(turn == 1 && pieceColor.equals("b")){
        return true
    }
    return false
}

fun isCoordinateInsideChess (coord:Pair<Int, Int>,numColumns:Int,numLines: Int):Boolean{
    if(numColumns == 4 && numLines == 4){
        if(coord.first > 0 && coord.second > 0 && coord.first <= 4 && coord.second <= 4){
            return true
        }
    }
    else if(numColumns == 6 && numLines == 6){
        if(coord.first > 0 && coord.second > 0 && coord.first <= 6 && coord.second <= 6){
            return true
        }
    }
    else if(numColumns == 6 && numLines == 7){
        if(coord.first > 0 && coord.second > 0 && coord.first <= 6 && coord.second <= 7){
            return true
        }
    }
    else if(numColumns == 7 && numLines == 7){
        if(coord.first > 0 && coord.second > 0 && coord.first <= 7 && coord.second <= 7){
            return true
        }
    }
    else if(numColumns == 8 && numLines == 8){
        if(coord.first > 0 && coord.second > 0 && coord.first <= 8 && coord.second <= 8){
            return true
        }
    }
    return false
}

fun isValidTargetPiece(currentSelectedPiece : Pair<String, String>, currentCoord : Pair<Int, Int>,
                       targetCoord : Pair<Int, Int>, pieces : Array<Pair<String, String>?>,
                       numColumns: Int, numLines: Int): Boolean{
    if(pieces[numColumns * (targetCoord.first-1) + (targetCoord.second-1)] == null){
        return true
    }
    else if(!(currentSelectedPiece.second.equals(pieces[numColumns*(targetCoord.first-1) + (targetCoord.second-1)]?.second))){
        return true
    }
    return false
}

fun movePiece(pieces : Array<Pair<String, String>?>, numColumns: Int,
              numLines: Int, currentCoord: Pair<Int, Int>,
              targetCoord: Pair<Int, Int>, totalPiecesAndTurn : Array<Int>):Boolean{
    if(isValidTargetPiece(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)] as Pair<String,String>,
            currentCoord,targetCoord,pieces,numColumns,numLines)){
        if(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.first.equals("T")){
            if(isTowerValid(currentCoord,targetCoord,pieces,numColumns,numLines)){
                updatePiecesOnBoard(pieces,numColumns,numLines,currentCoord,targetCoord)
                updateGameStatus(totalPiecesAndTurn,pieces)
                return true
            }
        }
        else if(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.first.equals("B")){
            if(isBishopValid(currentCoord,targetCoord,pieces,numColumns,numLines)){
                updatePiecesOnBoard(pieces,numColumns,numLines,currentCoord,targetCoord)
                updateGameStatus(totalPiecesAndTurn,pieces)
                return true
            }
        }
        else if(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.first.equals("Q")){
            if(isQueenValid(currentCoord,targetCoord,pieces,numColumns,numLines)){
                updatePiecesOnBoard(pieces,numColumns,numLines,currentCoord,targetCoord)
                updateGameStatus(totalPiecesAndTurn,pieces)
                return true
            }
        }
        else if(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.first.equals("P")){
            if(isKnightValid(currentCoord,targetCoord,pieces,numColumns,numLines)){
                updatePiecesOnBoard(pieces,numColumns,numLines,currentCoord,targetCoord)
                updateGameStatus(totalPiecesAndTurn,pieces)
                return true
            }
        }
        else if(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.first.equals("K")){
            if(isKingValid(currentCoord,targetCoord,pieces,numColumns,numLines)){
                updatePiecesOnBoard(pieces,numColumns,numLines,currentCoord,targetCoord)
                updateGameStatus(totalPiecesAndTurn,pieces)
                return true
            }
        }
        else if(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.first.equals("H")){
            if(isHorseValid(currentCoord,targetCoord,pieces,numColumns,numLines)){
                updatePiecesOnBoard(pieces,numColumns,numLines,currentCoord,targetCoord)
                updateGameStatus(totalPiecesAndTurn,pieces)
                return true
            }
        }
    }
    return false
}

fun updatePiecesOnBoard(pieces : Array<Pair<String, String>?>, numColumns: Int,
                        numLines: Int, currentCoord: Pair<Int, Int>,
                        targetCoord: Pair<Int, Int>){
    val temp = pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]
    pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)] = null
    pieces[numColumns*(targetCoord.first-1)+(targetCoord.second-1)] = temp
}

fun updateGameStatus(totalPiecesAndTurn : Array<Int>,pieces : Array<Pair<String, String>?>){
    var whitePieces = 0
    var blackPieces = 0
    var counter = 0
    while (counter < pieces.size){
        if(pieces[counter]?.second.equals("w")){
            whitePieces++
        }
        else if(pieces[counter]?.second.equals("b")){
            blackPieces++
        }
        counter++
    }
    totalPiecesAndTurn[0] = whitePieces
    totalPiecesAndTurn[1] = blackPieces
}
fun startNewGame (whitePlayer: String, blackPlayer: String, pieces : Array<Pair<String, String>?>,
                  totalPiecesAndTurn : Array<Int?>, numColumns: Int,numLines: Int, showLegend: Boolean = false,
                  showPieces: Boolean = false){
    val gameStatus: Array<Int?> = createTotalPiecesAndTurn(numColumns,numLines)
    while(gameStatus[0] != 0 && gameStatus[1] != 0){
        println(buildBoard(numColumns,numLines,showLegend,showPieces,pieces))
        var pieceChoosed = ""
        var targetChoosed = ""
        var goodPiece = false
        var currentCoord = Pair(0,0)

        do {
            if(gameStatus[2] == 0){
                pieceChoosed = getChoosedPiece(whitePlayer)
            } else{
                pieceChoosed = getChoosedPiece(blackPlayer)
            }
            if("m".equals(pieceChoosed)){
                return
            }
            else{
                if(getCoordinates(pieceChoosed) != null && gameStatus[2] != null){
                    if(isCoordinateInsideChess(getCoordinates(pieceChoosed) as Pair<Int, Int>,numColumns,numLines)
                        &&checkRightPieceSelected(getColorPiece(pieces,getCoordinates(pieceChoosed) as Pair<Int, Int>,numColumns),
                            gameStatus[2] as Int)){
                        currentCoord = getCoordinates(pieceChoosed) as Pair<Int,Int>
                        if(gameStatus[2] == 0){
                            targetChoosed = getChoosedTarget(whitePlayer)
                        }else{
                            targetChoosed = getChoosedTarget(blackPlayer)
                        }
                        if("m".equals(targetChoosed)){
                            return
                        }
                        else{
                            if(getCoordinates(targetChoosed) != null){
                                if(isCoordinateInsideChess(getCoordinates(targetChoosed) as Pair<Int, Int>, numColumns,numLines) &&
                                    movePiece(pieces,numColumns,numLines,currentCoord,getCoordinates(targetChoosed) as Pair<Int, Int>,
                                        gameStatus as Array<Int>)){
                                    goodPiece = true
                                }else{
                                    goodPiece = invalidateMove(goodPiece,numColumns,numLines,showLegend,showPieces,pieces)
                                }
                            }
                        }
                    }
                    else{
                        goodPiece = invalidateMove(goodPiece,numColumns,numLines,showLegend,showPieces,pieces)
                    }
                }else{
                    goodPiece = invalidateMove(goodPiece,numColumns,numLines,showLegend,showPieces,pieces)
                }
            }
        }while(!goodPiece)
        if(gameStatus[2] == 0){
            gameStatus[2] = 1
        }else{
            gameStatus[2] = 0
        }
    }
    println(generateResults(gameStatus,blackPlayer,whitePlayer))
}

fun getChoosedPiece(player: String): String{
    val choosePieceMsg = ", choose a piece (e.g 2D).\nMenu-> m;"
    println(player + choosePieceMsg + '\n')
    val pieceChoosed = readLine()!!
    return pieceChoosed
}

fun getChoosedTarget(player: String): String{
    val chooseTargetMsg = ", choose a target piece (e.g 2D).\nMenu-> m;"
    println(player + chooseTargetMsg + '\n')
    val targetChoosed = readLine()!!
    return targetChoosed
}

fun generateResults(gameStatus: Array<Int?>, blackPlayer:String, whitePlayer:String):String{
    if(gameStatus[0] == 0){
        return "Congrats! $blackPlayer wins!"
    }
    else if(gameStatus[1] == 0){
        return "Congrats! $whitePlayer wins!"
    }
    return ""
}

fun invalidateMove(goodPiece:Boolean,cols:Int,lines:Int,showLeg:Boolean, showPieces:Boolean,pieces:Array<Pair<String, String>?>): Boolean{
    println(invalidMessage)
    println(buildBoard(cols,lines,showLeg,showPieces,pieces))
    return false
}

fun isHorseValid(currentCoord:Pair<Int, Int>,targetCoord : Pair<Int,Int>, pieces : Array<Pair<String,String>?>,
                 numColumns: Int, numLines:Int): Boolean{
    if(targetCoord == Pair(currentCoord.first+1, currentCoord.second-2)){
        if(!(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.second.
            equals(pieces[numColumns*(targetCoord.first-1)+(targetCoord.second-1)]?.second))){
            return true
        }
    }
    if(targetCoord == Pair(currentCoord.first+1, currentCoord.second+2)){

        if(!(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.second.
            equals(pieces[numColumns*(targetCoord.first-1)+(targetCoord.second-1)]?.second))){
            return true
        }
    }
    if(targetCoord == Pair(currentCoord.first-1, currentCoord.second+2)){

        if(!(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.second.
            equals(pieces[numColumns*(targetCoord.first-1)+(targetCoord.second-1)]?.second))){
            return true
        }

    }
    if(targetCoord == Pair(currentCoord.first-1, currentCoord.second-2)){
        if(!(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.second.
            equals(pieces[numColumns*(targetCoord.first-1)+(targetCoord.second-1)]?.second))){
            return true
        }
    }
    if(targetCoord == Pair(currentCoord.first+2, currentCoord.second+1)){
        if(!(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.second.
            equals(pieces[numColumns*(targetCoord.first-1)+(targetCoord.second-1)]?.second))){
            return true
        }
    }
    if(targetCoord == Pair(currentCoord.first+2, currentCoord.second-1)){
        if(!(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.second.
            equals(pieces[numColumns*(targetCoord.first-1)+(targetCoord.second-1)]?.second))){
            return true
        }
    }
    if(targetCoord == Pair(currentCoord.first-2, currentCoord.second+1)){
        if(!(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.second.
            equals(pieces[numColumns*(targetCoord.first-1)+(targetCoord.second-1)]?.second))){
            return true
        }

    }
    if(targetCoord == Pair(currentCoord.first-2, currentCoord.second-1)){
        if(!(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.second.
            equals(pieces[numColumns*(targetCoord.first-1)+(targetCoord.second-1)]?.second))){
            return true
        }
    }
    return false
}

fun isKingValid(currentCoord:Pair<Int, Int>,targetCoord : Pair<Int,Int>, pieces: Array<Pair<String,String>?>,
                numColumns: Int, numLines:Int):Boolean{
    if(targetCoord == Pair(currentCoord.first, currentCoord.second+1)){
        if(!(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.second.
            equals(pieces[numColumns*(targetCoord.first-1)+(targetCoord.second-1)]?.second))){
            return true
        }
    }
    if(targetCoord == Pair(currentCoord.first, currentCoord.second-1)){
        if(!(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.second.
            equals(pieces[numColumns*(targetCoord.first-1)+(targetCoord.second-1)]?.second))){
            return true
        }
    }
    if(targetCoord == Pair(currentCoord.first+1, currentCoord.second)){
        if(!(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.second.
            equals(pieces[numColumns*(targetCoord.first-1)+(targetCoord.second-1)]?.second))){
            return true
        }
    }
    if(targetCoord == Pair(currentCoord.first-1, currentCoord.second)){
        if(!(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.second.
            equals(pieces[numColumns*(targetCoord.first-1)+(targetCoord.second-1)]?.second))){
            return true
        }
    }
    if(targetCoord == Pair(currentCoord.first+1, currentCoord.second+1)){
        if(!(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.second.
            equals(pieces[numColumns*(targetCoord.first-1)+(targetCoord.second-1)]?.second))){
            return true
        }
    }
    if(targetCoord == Pair(currentCoord.first-1, currentCoord.second-1)){
        if(!(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.second.
            equals(pieces[numColumns*(targetCoord.first-1)+(targetCoord.second-1)]?.second))){
            return true
        }
    }
    if(targetCoord == Pair(currentCoord.first+1, currentCoord.second-1)){
        if(!(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.second.
            equals(pieces[numColumns*(targetCoord.first-1)+(targetCoord.second-1)]?.second))){
            return true
        }
    }
    if(targetCoord == Pair(currentCoord.first-1, currentCoord.second+1)){
        if(!(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.second.
            equals(pieces[numColumns*(targetCoord.first-1)+(targetCoord.second-1)]?.second))){
            return true
        }
    }
    return false
}

fun isTowerValid(currentCoord: Pair<Int, Int>,targetCoord: Pair<Int,Int>, pieces: Array<Pair<String,String>?>,
                 numColumns: Int,numLines: Int):Boolean{
    if (currentCoord != targetCoord) {
        if (currentCoord.first == targetCoord.first || currentCoord.second == targetCoord.second) {
            if(!(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.second.
                equals(pieces[numColumns*(targetCoord.first-1)+(targetCoord.second-1)]?.second))){
                return true
            }
        }
    }
    return false
}

fun isBishopValid(currentCoord: Pair<Int, Int>,targetCoord: Pair<Int,Int>, pieces: Array<Pair<String,String>?>,
                  numColumns: Int,numLines:Int): Boolean{
    var ref = 1
    while (ref < numColumns){
        if(targetCoord.first == currentCoord.first-ref && targetCoord.second == currentCoord.second-ref){
            if(!(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.second.
                equals(pieces[numColumns*(targetCoord.first-1)+(targetCoord.second-1)]?.second))){
                return true
            }
        }
        else if(targetCoord.first == currentCoord.first-ref && targetCoord.second == currentCoord.second+ref){
            if(!(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.second.
                equals(pieces[numColumns*(targetCoord.first-1)+(targetCoord.second-1)]?.second))){
                return true
            }
        }
        else if(targetCoord.first == currentCoord.first+ref && targetCoord.second == currentCoord.second-ref){
            if(!(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.second.
                equals(pieces[numColumns*(targetCoord.first-1)+(targetCoord.second-1)]?.second))){
                return true
            }
        }
        else if(targetCoord.first == currentCoord.first+ref && targetCoord.second == currentCoord.second+ref){
            if(!(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.second.
                equals(pieces[numColumns*(targetCoord.first-1)+(targetCoord.second-1)]?.second))){
                return true
            }
        }
        ref++
    }
    return false
}

fun isQueenValid(currentCoord:Pair<Int, Int>,targetCoord: Pair<Int,Int>,
                 pieces: Array<Pair<String,String>?>, numColumns: Int,numLines:Int):Boolean{
    if(isBishopValid(currentCoord,targetCoord,pieces,numColumns,numLines) ||
        isTowerValid(currentCoord,targetCoord,pieces,numColumns,numLines)){
        if(!(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.second.
            equals(pieces[numColumns*(targetCoord.first-1)+(targetCoord.second-1)]?.second))){
            return true
        }
    }
    return false
}

fun isKnightValid(currentCoord:Pair<Int, Int>,targetCoord: Pair<Int,Int>, pieces: Array<Pair<String,String>?>,
                  numColumns: Int,numLines:Int):Boolean{
    if(targetCoord == Pair(currentCoord.first-1,currentCoord.second)
        || targetCoord == Pair(currentCoord.first+1,currentCoord.second)){
        if(!(pieces[numColumns*(currentCoord.first-1)+(currentCoord.second-1)]?.second.
            equals(pieces[numColumns*(targetCoord.first-1)+(targetCoord.second-1)]?.second))){
            return true
        }
    }
    return false
}

fun getColorPiece(pieces : Array<Pair<String, String>?>,coord: Pair<Int,Int>, numColumns: Int): String{
    val index = numColumns * (coord.first-1) + (coord.second-1)
    return pieces[index]?.second.toString()
}

fun main(){
    var opcao: Int = 0
    var input: String = ""
    var firstName: String = ""
    var secondName: String = ""
    var columns: Int = 0
    var lines: Int = 0
    var showLegends: Boolean = false
    var showPieces: Boolean = false

    println("Welcome to the Chess Board Game!")
    do{
        println(buildMenu())
        input = readLine()!!
        if(checkIsNumber(input)){
            opcao = input.toInt()
            if(opcao == 1) {
                firstName = getFirstName()
                secondName = getSecondName()
                var invalidBoard = true
                while(invalidBoard) {
                    columns = getColumnsNumber()
                    lines = getLinesNumber()
                    if (columns == 8 && lines == 8){
                        invalidBoard = false
                    }
                    else if (columns == 7 && lines == 7){
                        invalidBoard = false
                    }
                    else if (columns == 6 && lines == 6){
                        invalidBoard = false
                    }
                    else if (columns == 6 && lines == 7){
                        invalidBoard = false
                    }
                    else if (columns == 4 && lines == 4){
                        invalidBoard = false
                    }
                    if(invalidBoard){
                        println(invalidMessage)
                    }
                }
                showLegends = showLegend()
                showPieces = showPieces()

                startNewGame(firstName, secondName, createInitialBoard(columns,lines),
                    createTotalPiecesAndTurn(columns,lines),
                    columns, lines, showLegends, showPieces)
            }
        }
        else{
            println(invalidMessage)
        }
    }while(opcao != 2)
}