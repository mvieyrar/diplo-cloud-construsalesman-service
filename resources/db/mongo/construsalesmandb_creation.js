use admin;
db.createUser(
{
	user: "construsalesman_owner",
	pwd: "construsalesman_password",
	roles: [{role: "userAdmin", db: "construsalesmandb"}]
})
