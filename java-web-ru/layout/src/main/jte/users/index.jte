
@import  exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    @if(page.getUsers().isEmpty())
        <p>No users so far...</p>
    @else
        @for(var user : page.getUsers())
            <div>
                <h2><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></h2>
                <p>${user.getEmail()}</p>
            </div>
        @endfor
    @endif
`
)