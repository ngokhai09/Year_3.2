using Sach.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;


public class BaiThiController : Controller
{
    // GET: BaiThi

    ThuVienDB thuVienDB = new ThuVienDB();
    public ActionResult Index()
    {
        return View();
    }
    public ActionResult RenCategories()
    {
        List<tLoaiSach> tLoaiSaches = thuVienDB.tLoaiSaches.Take(4).ToList();
        return PartialView("NgoVanKhai_Header", tLoaiSaches);
    }
    public ActionResult RenBook()
    {
        List<tSach> tSaches = thuVienDB.tSaches.Where(n => n.MaNgonNgu == "001").Take(2).ToList();
        return PartialView("NgoVanKhai_MainContent", tSaches);
    }
    public ActionResult RenBookByCatId(string id)
    {
        List<tSach> tSaches = thuVienDB.tSaches.Where(n => n.MaLoai == id).ToList();
        return PartialView("NgoVanKhai_NewProduct", tSaches);
    }
    public ActionResult CreateBook()
    {
        ViewBag.MaLoai = new SelectList(thuVienDB.tSaches.ToList().OrderBy(n => n.TenSach), "MaSach", "TenSach");
        ViewBag.MaNgonNgu = new SelectList(thuVienDB.tNgonNgus.ToList().OrderBy(n => n.TenNgonNgu), "MaNgonNgu", "TenNgonNgu");
        ViewBag.MaNXB = new SelectList(thuVienDB.tNhaXBs.ToList().OrderBy(n => n.TenNXB), "MaNXB", "TenNXB");
        return View();
    }
    [HttpPost]
    public ActionResult CreateBook(tSach sach)
    {
        ViewBag.MaLoai = new SelectList(thuVienDB.tSaches.ToList().OrderBy(n => n.TenSach), "MaSach", "TenSach");
        ViewBag.MaNgonNgu = new SelectList(thuVienDB.tNgonNgus.ToList().OrderBy(n => n.TenNgonNgu), "MaNgonNgu", "TenNgonNgu");
        ViewBag.MaNXB = new SelectList(thuVienDB.tNhaXBs.ToList().OrderBy(n => n.TenNXB), "MaNXB", "TenNXB");
        return View();
        if (ModelState.IsValid)
        {
            thuVienDB.tSaches.Add(sach);
            thuVienDB.SaveChanges();
            return Redirect("Index");
        }
        return View();
    }
}
