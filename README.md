# MatchPoint 🏐⚡

**MatchPoint** é um aplicativo Android para organizar jogos de vôlei, montar equipes e acompanhar o placar com facilidade.

> **Status:** versão de testes (V10). O aplicativo funciona localmente no dispositivo; ainda não há sincronização em nuvem nem distribuição pela Play Store.

## Funcionalidades

| Área | O que oferece |
| --- | --- |
| **Jogadores e turmas** | Cadastro, organização por turma, convocação e registro de presença. |
| **Equipes** | Sorteio equilibrado, montagem manual, reservas, chegada tardia e movimentação de jogadores entre times com prévia visual. |
| **Placar da partida** | Números com efeito mecânico de virar folha, gestos para pontuar, inversão dos lados e tela cheia. |
| **⚡ Placar rápido** | Placar independente de cadastros, nomes e cores personalizáveis, equipes em espera, sets e tela cheia. |
| **Partidas e ranking** | Histórico de resultados e classificação dos jogadores. |

## Tecnologias

- **Android:** Java e WebView.
- **Interface:** HTML, CSS e JavaScript na pasta app/src/main/assets/.
- **Build:** Gradle 8.9, Android Gradle Plugin 8.7.3, Java 17 e SDK Android 35.
- **CI:** GitHub Actions, com geração automatizada de APK de teste.

O aplicativo carrega a interface a partir dos arquivos Android. Fontes externas podem depender de conexão com a internet.

## Compilar o aplicativo

### Pelo GitHub Actions

1. Acesse **Actions** → **Gerar APK MatchPoint**.
2. Selecione uma execução bem-sucedida ou inicie uma com **Run workflow**.
3. Baixe o artefato **MatchPoint-Versao-10-Android**.
4. Extraia o arquivo app-debug.apk e instale no Android.

O workflow também executa em atualizações da branch principal e em pull requests destinados a ela.

### Localmente

Com Java 17, Gradle 8.9 e o Android SDK configurados:

~~~bash
gradle :app:assembleDebug --no-daemon
~~~

O APK será gerado em app/build/outputs/apk/debug/app-debug.apk.

## Estrutura do repositório

~~~text
app/
  build.gradle                    Configurações do módulo Android
  src/main/
    AndroidManifest.xml           Configurações do aplicativo
    java/.../MainActivity.java    WebView e arquivos locais
    assets/
      index.html                  Interface e regras do MatchPoint
      manifest.webmanifest        Metadados da interface web
      icons/                      Ícones da interface
    res/drawable/icone.png        Ícone Android
.github/workflows/android-apk.yml  Compilação automatizada
build.gradle                       Plugins Gradle
settings.gradle                    Nome e módulos do projeto
gradle.properties                  Propriedades do Gradle
README.md                          Guia do projeto
CHANGELOG.md                       Resumo de atualizações
.gitignore                         Arquivos locais não versionados
~~~

## Dados e limitações

Os jogadores, resultados e ajustes ficam armazenados **no próprio dispositivo** (WebView/localStorage), sem conta ou backup automático. Desinstalar o aplicativo ou limpar seus dados pode apagar essas informações.

Os APKs gerados pelo workflow são **debug**, não releases de produção. A assinatura de debug pode variar entre compilações; uma atualização pode exigir reinstalação, com risco de perda dos dados locais. Tenha isso em mente antes de usar o app com dados importantes.

O identificador Android existente foi mantido para evitar alterações desnecessárias na identidade de instalação.

## Como colaborar

- Crie uma branch para alterações no aplicativo.
- Abra um pull request e verifique se o build do GitHub Actions concluiu com sucesso.
- Registre mudanças relevantes no [CHANGELOG.md](CHANGELOG.md).
- Relate erros com passos para reproduzir, versão do Android e comportamento esperado.

---

Desenvolvido para tornar a organização do vôlei mais simples e visual. 💚
