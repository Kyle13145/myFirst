package com.sw.digital.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sw.digital.entity.GoodsImg;
import com.sw.digital.entity.Image;
import com.sw.digital.entity.User;

@RestController
@RequestMapping("/file")
public class ImageUploadController {


	//单文件上传
	@RequestMapping(value="/imgUpload",method=RequestMethod.POST)
	public ResponseEntity<?> imgFileUpload(@RequestParam("file")MultipartFile file,HttpServletRequest request) throws FileNotFoundException{

		File path = new File(ResourceUtils.getURL("classpath:").getPath());
		if(!path.exists()) path = new File("");
		System.out.println("path:"+path.getAbsolutePath());
		if(file!=null) {
			String fileName=System.currentTimeMillis()+(int)(Math.random()*1000)+file.getOriginalFilename();

			File dir = new File(path+"//static//imgDir");
			File img = new File(path+"//static//imgDir//"+fileName);
			try {
				if(!dir.isDirectory()) {
					dir.mkdirs();
				}
				if(!img.exists()) {
					img.createNewFile();
				}
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(img));
				bos.write(file.getBytes());
				bos.flush();
				bos.close();
				Image a =new Image();
				a.setSrc("imgDir/"+fileName);
				return new ResponseEntity<Image>(a, HttpStatus.OK);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			return new ResponseEntity<String>("", HttpStatus.OK);
		}
		return new ResponseEntity<String>("", HttpStatus.OK);
	}

	//多文件上传
	@RequestMapping(value="/imgUploads",method=RequestMethod.POST)
	public ResponseEntity<?> imgFileUploads(@RequestParam("file")MultipartFile[] file) throws FileNotFoundException{
		List<GoodsImg> goodsList = new ArrayList<GoodsImg>();
		File path = new File(ResourceUtils.getURL("classpath:").getPath());
		if(!path.exists()) path = new File("");
		System.out.println("path:"+path.getAbsolutePath());
		if(file!=null) {
			for(int i=0;i<file.length;i++) {
				String fileName=System.currentTimeMillis()+(int)(Math.random()*1000)+file[i].getOriginalFilename();
				File dir = new File(path+"//static//imgDir");
				File img = new File(path+"//static//imgDir//"+fileName);
				try {
					if(!dir.isDirectory()) {
						dir.mkdirs();
					}
					if(!img.exists()) {
						img.createNewFile();
					}
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(img));
					bos.write(file[i].getBytes());
					bos.flush();
					bos.close();
					GoodsImg goodsImg =new GoodsImg();
					goodsImg.setSrc("imgDir/"+fileName);
					goodsList.add(goodsImg);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			return new ResponseEntity<List<GoodsImg>>(goodsList, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
	}

}
