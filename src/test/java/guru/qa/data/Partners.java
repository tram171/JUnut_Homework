package guru.qa.data;


public enum Partners {

    DIRECTBANK("1С:Директбанк", "Объединяет 1С и банк в единый механизм и делает учёт удобным"),
    EKONTUR("Контур.Эльба", "Упрощает бухгалтерский учёт, экономит время и силы"),
    KONTUREKSTERN("Контур.Экстерн", "Автоматизирует всё самое сложное, чтобы у тебя было больше свободного времени");

    public final String partnerName;
    public final String description;
    Partners(String partnerName, String description){
        this.partnerName = partnerName;
        this.description = description;
    }
}