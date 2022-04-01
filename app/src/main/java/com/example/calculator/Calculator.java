package com.example.calculator;

public class Calculator {
    private int firstArg;
    private  int secondArg;
    private int action;

    StringBuilder inputString=new StringBuilder();

    private State state;
    //состояние калькулятора
    private enum State{
        firstArgInput,secondArgInput,result

    }
    //конструктор для инициализации поля
    public Calculator(){
        state=State.firstArgInput;
    }
//реакция на кнопку с цифрой
    public void onNumberPress(int numberId){
        //если біл показан результат то состоние калькулятора переходит в вод первого аргумента
        if(state==State.result)
            state=State.firstArgInput;
//ограничение на кол-во символов
        if(inputString.length()<10){
            switch (numberId){
                case R.id.zero:
//                    if(inputString.length()!=0)
                    inputString.append("0");
                    break;
                case R.id.one:
                           inputString.append("1");
                    break;
                case R.id.two:
                    inputString.append("2");
                    break;
                case R.id.three:
                    inputString.append("3");
                    break;
                case R.id.four:
                    inputString.append("4");
                    break;
                case R.id.five:
                    inputString.append("5");
                    break;
                case R.id.six:
                    inputString.append("6");
                    break;
                case R.id.seven:
                    inputString.append("7");
                    break;
                case R.id.eight:
                    inputString.append("8");
                    break;
                case R.id.nine:
                    inputString.append("9");
                    break;
            }
        }
    }
    //реакция на действие
    public void onActionPress(int actionId){
        if (actionId == R.id.equals && state == State.secondArgInput) {
            secondArg = Integer.parseInt(inputString.toString());
            state = State.result;
            inputString.setLength(0);
            switch (action) {
                case R.id.plus:
                    inputString.append(firstArg + secondArg);
                    break;
                case R.id.minus:
                    inputString.append(firstArg - secondArg);
                    break;
                case R.id.multiply:
                    inputString.append(firstArg * secondArg);
                    break;
                case R.id.division:
                    inputString.append(firstArg / secondArg);
                    break;
            }

        } else if (inputString.length() > 0 && state == State.firstArgInput) {
            firstArg = Integer.parseInt(inputString.toString());
            state = State.secondArgInput;
            inputString.setLength(0);
            switch (actionId) {
                case R.id.plus:
                    action=R.id.plus;
                    break;
                case R.id.minus:
                    action=R.id.minus;
                    break;
                case R.id.multiply:
                    action=R.id.multiply;
                    break;
                case R.id.division:
                    action=R.id.division;
                    break;
            }
        }
    }


    //отображаем текст в текстовом поле
    public String getText(){
        return inputString.toString();
    }

    public void reset(){
        state=State.firstArgInput;
        inputString.setLength(0);
    }
}
