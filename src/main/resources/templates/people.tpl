yieldUnescaped '<!DOCTYPE html>'
html(lang:'en') {
    head {
        title('Famous people in IT')
    }
    body {
        ul {
            listOfPeople.each { person ->
                li(person.name)
            }
        }
    }
}