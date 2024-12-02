package enums;

public enum ESTADOINICIAL {
    Leve_e_Estavel {
        @Override
        public String toString() {
            return "Leve e Estável";
        }
    },
    Leve_e_Instavel {
        @Override
        public String toString() {
            return "Leve e Instável";
        }
    },
    Moderado_e_Estavel {
        @Override
        public String toString() {
            return "Moderado e Estavel";
        }
    },
    Moderado_e_Instavel {
        @Override
        public String toString() {
            return "Moderado e Instável";
        }
    },
    Grave_e_Estavel {
        @Override
        public String toString() {
            return "Grave e Estável";
        }
    },
    Grave_e_Instavel {
        @Override
        public String toString() {
            return "Grave e Instável";
        }
    },
    Critico_e_Estavel {
        @Override
        public String toString() {
            return "Crítico e Estável";
        }
    },
    Critico_e_Instavel {
        @Override
        public String toString() {
            return "Crítico e Instável";
        }
    },
}