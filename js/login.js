

document.getElementById("loginForm").addEventListener("submit", async function(e) {
    e.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    const response = await fetch("http://localhost:8080/api/auth/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            username: username,   // BELANGRIJK
            password: password
        })
    });

    const result = await response.text();

    if (response.ok) {
        alert("Login succesvol!");
    } else {
        alert("Login mislukt: " + result);
    }
});