package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    CheckBox one, two, three;
    TextView NumberQuestao, Questao1;
    Button submit;
    int perg = 1, classificacao = 0, numerQuestion = 1;

    String[] Pergunta = {"Para que serve, numa arma, a coronha ?", "Qual a afirmação correta ?", "Qual o comprimento mais vulgar das câmaras de um espingarda ?",
            "Um individuo cujo o olho diretor seja o esquerdo, deverá apontar :", "Quais os principais elementos da adaptação da coronha ao atirador ?",
            "O que é a câmara de explosão de uma espingarda ?", "Qual a função do guarda mato ?", "O cano é composto por 4 zonas. Quais são ?",
            "Quais as partes que constituem uma espingarda de canos sobrepostos ?", "Uma coronha com muita queda designa-se por :"
            };

    String[] Respostas1 = {"Para fazer pontaria.", "Para apoiar a arma no ombro.", "Para disparar a arma."};

    String[] Respostas2 = {"As Espingardas podem atirar projecteis únicos (balas).", "As carabinas não são tão precisas como as espingardas.", "As espingardas são mais potentes que as carabinas."};

    String[] Respostas3 = {"60mm e 65mm.", "76mm.", "65mm e 70mm."};

    String[] Respostas4 = {"Com a vista esquerda.", "Com a direita.", "Tanto faz."};

    String[] Respostas5 = {"Comprimento e queda.", "Comprimento, queda, desvio lateral e almofada.", "Queda, largura e Cast-off."};

    String[] Respostas6 = {"A câmara é o depósito de cartuchos de uma semiautomática.", "A câmara é a superfície interior do cano", "A câmara é o local onde se introduz e percute o cartucho."};

    String[] Respostas7 = {"Tornar a arma mais atraente.", "Contribuir para a segurança do gatilho, protegendo-o.", "Indicar mais facilmente onde se encontra o Gatilho."};

    String[] Respostas8 = {"Câmara, ponto de mira, boca e alma.", "Alma, câmara, fuste, e choque.", "Câmara, alma, estrangulamento ou choque e boca."};

    String[] Respostas9 = {"Cano, Báscula ou Culatra Móvel e Coronha.", "Báscula, Culatra e Fuste.", "Canos, Caixa de Mecanismos, Coronha e Fuste."};

    String[] Respostas10 = {"Coronha caída.", "Coronha direita.", "Coronha inglesa."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.logo);

        NumberQuestao = (TextView) findViewById(R.id.NumberQuestion);
        Questao1 = (TextView) findViewById(R.id.Questions);
        submit = (Button) findViewById(R.id.submeter);
        one = (CheckBox) findViewById(R.id.resposta1);
        two = (CheckBox) findViewById(R.id.resposta2);
        three = (CheckBox) findViewById(R.id.resposta3);

        NumberQuestao.setText("Questão " + numerQuestion);
        Questao1.setText(Pergunta[0]);
        one.setText(Respostas1[0]);
        two.setText(Respostas1[1]);
        three.setText(Respostas1[2]);
    }

    public void btSubmit(View view) {

        switch (perg) {

            case 1:
                if (!one.isChecked() && !two.isChecked() && !three.isChecked()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Nenhuma opção selecionada!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                    toast.show();
                } else {
                    if (one.isChecked() && two.isChecked() && three.isChecked()) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Apenas pode selecionar uma opção!", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                        toast.show();
                    } else {
                        if ((one.isChecked() && two.isChecked()) || (one.isChecked() && three.isChecked()) || (two.isChecked() && three.isChecked())) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Apenas pode selecionar uma opção!", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                            toast.show();
                        } else {
                            if (two.isChecked() && !one.isChecked() && !three.isChecked()) {
                                classificacao = classificacao + 1;
                                two.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Correta!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            if (one.isChecked() && !two.isChecked() && !three.isChecked()) {
                                one.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Errada!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            if (three.isChecked() && !one.isChecked() && !two.isChecked()) {
                                three.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Errada!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            perg++;
                            numerQuestion++;

                            NumberQuestao.setText("Questão " + numerQuestion);
                            Questao1.setText(Pergunta[1]);
                            one.setText(Respostas2[0]);
                            two.setText(Respostas2[1]);
                            three.setText(Respostas2[2]);
                        }
                    }
                }
                break;

            case 2:
                if (!one.isChecked() && !two.isChecked() && !three.isChecked()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Nenhuma opção selecionada!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                    toast.show();
                } else {
                    if (one.isChecked() && two.isChecked() && three.isChecked()) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Apenas pode selecionar uma opção!", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                        toast.show();
                    } else {
                        if ((one.isChecked() && two.isChecked()) || (one.isChecked() && three.isChecked()) || (two.isChecked() && three.isChecked())) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Apenas pode selecionar uma opção!", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                            toast.show();
                        } else {
                            if (one.isChecked() && !two.isChecked() && !three.isChecked()) {
                                classificacao = classificacao + 1;
                                one.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Correta!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            if (two.isChecked() && !one.isChecked() && !three.isChecked()) {
                                two.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Errada!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            if (three.isChecked() && !one.isChecked() && !two.isChecked()) {
                                three.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Errada!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            perg++;
                            numerQuestion++;

                            NumberQuestao.setText("Questão " + numerQuestion);
                            Questao1.setText(Pergunta[2]);
                            one.setText(Respostas3[0]);
                            two.setText(Respostas3[1]);
                            three.setText(Respostas3[2]);
                        }
                    }
                }
                break;

            case 3:
                if (!one.isChecked() && !two.isChecked() && !three.isChecked()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Nenhuma opção selecionada!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                    toast.show();
                } else {
                    if (one.isChecked() && two.isChecked() && three.isChecked()) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Apenas pode selecionar uma opção!", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                        toast.show();
                    } else {
                        if ((one.isChecked() && two.isChecked()) || (one.isChecked() && three.isChecked()) || (two.isChecked() && three.isChecked())) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Apenas pode selecionar uma opção!", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                            toast.show();
                        } else {
                            if (three.isChecked() && !one.isChecked() && !two.isChecked()) {
                                classificacao = classificacao + 1;
                                three.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Correta!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            if (one.isChecked() && !two.isChecked() && !three.isChecked()) {
                                one.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Errada!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            if (two.isChecked() && !one.isChecked() && !three.isChecked()) {
                                two.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Errada!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            perg++;
                            numerQuestion++;

                            NumberQuestao.setText("Questão " + numerQuestion);
                            Questao1.setText(Pergunta[3]);
                            one.setText(Respostas4[0]);
                            two.setText(Respostas4[1]);
                            three.setText(Respostas4[2]);
                        }
                    }
                }
                break;

            case 4:
                if (!one.isChecked() && !two.isChecked() && !three.isChecked()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Nenhuma opção selecionada!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                    toast.show();
                } else {
                    if (one.isChecked() && two.isChecked() && three.isChecked()) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Apenas pode selecionar uma opção!", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                        toast.show();
                    } else {
                        if ((one.isChecked() && two.isChecked()) || (one.isChecked() && three.isChecked()) || (two.isChecked() && three.isChecked())) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Apenas pode selecionar uma opção!", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                            toast.show();
                        } else {
                            if (one.isChecked() && !two.isChecked() && !three.isChecked()) {
                                classificacao = classificacao + 1;
                                one.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Correta!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            if (two.isChecked() && !one.isChecked() && !three.isChecked()) {
                                two.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Errada!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            if (three.isChecked() && !one.isChecked() && !two.isChecked()) {
                                three.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Errada!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            perg++;
                            numerQuestion++;

                            NumberQuestao.setText("Questão " + numerQuestion);
                            Questao1.setText(Pergunta[4]);
                            one.setText(Respostas5[0]);
                            two.setText(Respostas5[1]);
                            three.setText(Respostas5[2]);
                        }
                    }
                }
                break;

            case 5:
                if (!one.isChecked() && !two.isChecked() && !three.isChecked()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Nenhuma opção selecionada!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                    toast.show();
                } else {
                    if (one.isChecked() && two.isChecked() && three.isChecked()) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Apenas pode selecionar uma opção!", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                        toast.show();
                    } else {
                        if ((one.isChecked() && two.isChecked()) || (one.isChecked() && three.isChecked()) || (two.isChecked() && three.isChecked())) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Apenas pode selecionar uma opção!", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                            toast.show();
                        } else {
                            if (two.isChecked() && !one.isChecked() && !three.isChecked()) {
                                classificacao = classificacao + 1;
                                two.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Correta!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            if (one.isChecked() && !two.isChecked() && !three.isChecked()) {
                                one.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Errada!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            if (three.isChecked() && !one.isChecked() && !two.isChecked()) {
                                three.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Errada!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            perg++;
                            numerQuestion++;

                            NumberQuestao.setText("Questão " + numerQuestion);
                            Questao1.setText(Pergunta[5]);
                            one.setText(Respostas6[0]);
                            two.setText(Respostas6[1]);
                            three.setText(Respostas6[2]);
                        }
                    }
                }
                break;
            case 6:
                if (!one.isChecked() && !two.isChecked() && !three.isChecked()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Nenhuma opção selecionada!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                    toast.show();
                } else {
                    if (one.isChecked() && two.isChecked() && three.isChecked()) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Apenas pode selecionar uma opção!", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                        toast.show();
                    } else {
                        if ((one.isChecked() && two.isChecked()) || (one.isChecked() && three.isChecked()) || (two.isChecked() && three.isChecked())) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Apenas pode selecionar uma opção!", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                            toast.show();
                        } else {
                            if (three.isChecked() && !one.isChecked() && !two.isChecked()) {
                                classificacao = classificacao + 1;
                                three.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Correta!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            if (one.isChecked() && !two.isChecked() && !three.isChecked()) {
                                one.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Errada!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            if (two.isChecked() && !one.isChecked() && !three.isChecked()) {
                                two.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Errada!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            perg++;
                            numerQuestion++;

                            NumberQuestao.setText("Questão " + numerQuestion);
                            Questao1.setText(Pergunta[6]);
                            one.setText(Respostas7[0]);
                            two.setText(Respostas7[1]);
                            three.setText(Respostas7[2]);
                        }
                    }
                }
                break;
            case 7:
                if (!one.isChecked() && !two.isChecked() && !three.isChecked()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Nenhuma opção selecionada!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                    toast.show();
                } else {
                    if (one.isChecked() && two.isChecked() && three.isChecked()) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Apenas pode selecionar uma opção!", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                        toast.show();
                    } else {
                        if ((one.isChecked() && two.isChecked()) || (one.isChecked() && three.isChecked()) || (two.isChecked() && three.isChecked())) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Apenas pode selecionar uma opção!", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                            toast.show();
                        } else {
                            if (two.isChecked() && !one.isChecked() && !three.isChecked()) {
                                classificacao = classificacao + 1;
                                two.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Correta!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            if (one.isChecked() && !two.isChecked() && !three.isChecked()) {
                                one.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Errada!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            if (three.isChecked() && !one.isChecked() && !two.isChecked()) {
                                three.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Errada!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            perg++;
                            numerQuestion++;

                            NumberQuestao.setText("Questão " + numerQuestion);
                            Questao1.setText(Pergunta[7]);
                            one.setText(Respostas8[0]);
                            two.setText(Respostas8[1]);
                            three.setText(Respostas8[2]);
                        }
                    }
                }
                break;
            case 8:
                if (!one.isChecked() && !two.isChecked() && !three.isChecked()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Nenhuma opção selecionada!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                    toast.show();
                } else {
                    if (one.isChecked() && two.isChecked() && three.isChecked()) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Apenas pode selecionar uma opção!", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                        toast.show();
                    } else {
                        if ((one.isChecked() && two.isChecked()) || (one.isChecked() && three.isChecked()) || (two.isChecked() && three.isChecked())) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Apenas pode selecionar uma opção!", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                            toast.show();
                        } else {
                            if (three.isChecked() && !two.isChecked() && !one.isChecked()) {
                                classificacao = classificacao + 1;
                                three.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Correta!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            if (two.isChecked() && !one.isChecked() && !three.isChecked()) {
                                two.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Errada!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            if (one.isChecked() && !three.isChecked() && !two.isChecked()) {
                                one.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Errada!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            perg++;
                            numerQuestion++;

                            NumberQuestao.setText("Questão " + numerQuestion);
                            Questao1.setText(Pergunta[8]);
                            one.setText(Respostas9[0]);
                            two.setText(Respostas9[1]);
                            three.setText(Respostas9[2]);
                        }
                    }
                }
                break;
            case 9:
                if (!one.isChecked() && !two.isChecked() && !three.isChecked()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Nenhuma opção selecionada!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                    toast.show();
                } else {
                    if (one.isChecked() && two.isChecked() && three.isChecked()) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Apenas pode selecionar uma opção!", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                        toast.show();
                    } else {
                        if ((one.isChecked() && two.isChecked()) || (one.isChecked() && three.isChecked()) || (two.isChecked() && three.isChecked())) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Apenas pode selecionar uma opção!", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                            toast.show();
                        } else {
                            if (three.isChecked() && !two.isChecked() && !one.isChecked()) {
                                classificacao = classificacao + 1;
                                three.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Correta!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            if (two.isChecked() && !one.isChecked() && !three.isChecked()) {
                                two.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Errada!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            if (one.isChecked() && !three.isChecked() && !two.isChecked()) {
                                one.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Errada!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            perg++;
                            numerQuestion++;

                            NumberQuestao.setText("Questão " + numerQuestion);
                            Questao1.setText(Pergunta[9]);
                            one.setText(Respostas10[0]);
                            two.setText(Respostas10[1]);
                            three.setText(Respostas10[2]);
                        }
                    }
                }
                break;
            case 10:
                if (!one.isChecked() && !two.isChecked() && !three.isChecked()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Nenhuma opção selecionada!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                    toast.show();
                } else {
                    if (one.isChecked() && two.isChecked() && three.isChecked()) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Apenas pode selecionar uma opção!", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                        toast.show();
                    } else {
                        if ((one.isChecked() && two.isChecked()) || (one.isChecked() && three.isChecked()) || (two.isChecked() && three.isChecked())) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Apenas pode selecionar uma opção!", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                            toast.show();
                        } else {
                            if (one.isChecked() && !two.isChecked() && !three.isChecked()) {
                                classificacao = classificacao + 1;
                                one.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Correta!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            if (two.isChecked() && !one.isChecked() && !three.isChecked()) {
                                two.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Errada!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            if (three.isChecked() && !one.isChecked() && !two.isChecked()) {
                                three.setChecked(false);
                                Toast toast = Toast.makeText(getApplicationContext(), "Resposta Errada!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 750);
                                toast.show();
                            }
                            one.setVisibility(View.INVISIBLE);
                            two.setVisibility(View.INVISIBLE);
                            three.setVisibility(View.INVISIBLE);
                            submit.setVisibility(View.INVISIBLE);
                            NumberQuestao.setText("Questionário Finalizado !");
                            NumberQuestao.setTextSize(15);
                            Questao1.setText("Classificação : " + classificacao + " / 10");
                            Questao1.setTextSize(25);
                        }
                    }
                }
                break;
        }
    }
    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Deseja sair do Quizz?");
        builder.setCancelable(true);
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
