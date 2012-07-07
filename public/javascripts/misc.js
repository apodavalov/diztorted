function toggle_forum_registered()
{
    var checked = document.getElementById('forum_registered').checked;
    var forum_password = document.getElementById('forum_password');
    var comment_captcha = document.getElementById('comment_captcha');
    var comment_captcha_img = document.getElementById('comment_captcha_img');
    toggle_visible(comment_captcha, !checked);
    toggle_visible(comment_captcha_img, !checked);
    toggle_visible(forum_password, checked);
}

function show_by_id(id)
{
    toggle_by_id(id, true);
}

function toggle_by_id(id,visible)
{
    var element = document.getElementById(id);
    toggle_visible(element,visible);
}

function toggle_visible(element,visible)
{
    element.style.display = visible ? null : 'none';
}

function refresh_captcha_code()
{
    var img = document.getElementById('comment_captcha_code_img');
    img.src = 'get_captcha.php?' + Math.random();
}
